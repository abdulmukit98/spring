package edu.cseju.onetomany.controller;

import edu.cseju.onetomany.model.Department;
import edu.cseju.onetomany.model.Faculty;
import edu.cseju.onetomany.service.DeptService;
import edu.cseju.onetomany.service.FacultyService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("/user")
    public ModelAndView userView()
    {
        ModelAndView modelAndView = new ModelAndView();

        int accessTypeFlag = 0;
        modelAndView.addObject("accessTypeFlag",accessTypeFlag);

        List<Department> list = deptService.getAllDepartment();
        modelAndView.addObject("listOfModel",list);

        int Mode = 1;
        if(list.isEmpty()) Mode =0;
        modelAndView.addObject("Mode",Mode);

        modelAndView.setViewName("department");
        return modelAndView;
    }

    @RequestMapping("/admin")
    public ModelAndView adminView()
    {
        ModelAndView modelAndView = new ModelAndView();

        int accessTypeFlag=1;
        modelAndView.addObject("accessTypeFlag",accessTypeFlag);

        Department department = new Department();
        modelAndView.addObject("model",department);     // form entry

        List<Faculty> flist = facultyService.getAllFaculty();
        modelAndView.addObject("flist",flist);      // form entry faculty

        List<Department> list = deptService.getAllDepartment();
        modelAndView.addObject("listOfModel",list);     // Table view

        int Mode = 1;
        if(list.isEmpty()) Mode = 0;
        modelAndView.addObject("Mode",Mode);

        modelAndView.setViewName("department");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("model") Department department)
    {
        System.out.println(department.toString());

        Faculty faculty =new Faculty();
        faculty = facultyService.getFacultyById(department.getFaculty().getFacultyId());

        department.setFaculty(faculty);
        deptService.saveOrUpdate(department);

        return adminView();
    }

    @RequestMapping(value = "/admin/remove/{modelId}", method = RequestMethod.GET)
    public ModelAndView remove(@RequestParam("modelId") String modelId)
    {
        deptService.removeDepartment(modelId);
        return new ModelAndView("redirect:/department/admin");
    }

    @RequestMapping(value = "/faculty/{facultyId}")
    public ModelAndView findByFaculty(@RequestParam("facultyId") String factultyId)
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Department> list = deptService.getDepartmentByFaculty(factultyId);
        modelAndView.addObject("list",list);

        List<Faculty> flist = facultyService.getAllFaculty();
        modelAndView.addObject("flist",flist);
        modelAndView.setViewName("factId");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit/{modelId}", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("modelId") String modelId)
    {
        ModelAndView modelAndView = new ModelAndView();

        int Mode =2;
        modelAndView.addObject("Mode",Mode);

        Department model = deptService.getDepartmentById(modelId);
        modelAndView.addObject("model", model);

        int accessTypeFlag = 1;
        modelAndView.addObject("accessTypeFlag",accessTypeFlag);

        List<Faculty> flist = facultyService.getAllFaculty();
        modelAndView.addObject("flist", flist);

        modelAndView.setViewName("department");
        return modelAndView;
    }
}
