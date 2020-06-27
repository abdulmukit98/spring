package edu.cseju.onetomany.controller;

import edu.cseju.onetomany.model.Department;
import edu.cseju.onetomany.model.Student;
import edu.cseju.onetomany.service.DeptService;
import edu.cseju.onetomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("")
    public ModelAndView studentView()
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.getAllStudent();
        modelAndView.addObject("students",list);

        Student student = new Student();
        modelAndView.addObject("model",student);   //Form Entry object

        List<Department> dlist = deptService.getAllDepartment();
        modelAndView.addObject("dlist",dlist);

        modelAndView.setViewName("stdHtml");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("model") Student student)
    {
        Department department = new Department();
        department = deptService.getDepartmentById(student.getDept().getDeptId());

        student.setDept(department);
        studentService.saveOrUpdate(student);

        return studentView();
    }

    @RequestMapping(value = "/remove/{modelId}",method = RequestMethod.GET)
    public ModelAndView remove(@RequestParam("modelId") String modelId)
    {
        studentService.removeStudent(modelId);
        return new ModelAndView("redirect:/student");
    }

    @RequestMapping(value = "/edit/{modelId}", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("modelId") String modelId)
    {
        ModelAndView modelAndView = new ModelAndView();

        Student student = studentService.getStudentByRoll(modelId);
        modelAndView.addObject("model",student);

        List<Department> dlist = deptService.getAllDepartment();
        modelAndView.addObject("dlist",dlist);

        modelAndView.setViewName("stdHtml");
        return modelAndView;
    }

    @RequestMapping("/role")
    public ModelAndView roleView()
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.getAllStudent();
        modelAndView.addObject("listofstudent",list);
        modelAndView.setViewName("roleView");
        return modelAndView;
    }
}
