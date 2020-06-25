package edu.cseju.onetomany.controller;

import edu.cseju.onetomany.model.Faculty;
import edu.cseju.onetomany.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/user")
    public ModelAndView userView()
    {

        ModelAndView modelAndView = new ModelAndView();

        List<Faculty> list = facultyService.getAllFaculty();
        modelAndView.addObject("listOfModel", list);

        int Mode = 1;
        if(list.isEmpty()) Mode = 0;
        modelAndView.addObject("Mode", Mode);

        int accessTypeFlag = 0;  //  user access
        modelAndView.addObject("accessTypeFlag",accessTypeFlag);

        modelAndView.setViewName("faculty");    // html file name
        return modelAndView;
    }

    @RequestMapping("/admin")
    public ModelAndView adminView()
    {
        ModelAndView modelAndView = new ModelAndView();

        int accessTypeFlag = 1;
        modelAndView.addObject("accessTypeFlag",accessTypeFlag); // Admin View

        Faculty faculty = new Faculty();
        modelAndView.addObject("model", faculty); // Form th:object

        List<Faculty> list = facultyService.getAllFaculty();
        modelAndView.addObject("listOfModel",list);

        int Mode = 1;  // Table has data
        if(list.isEmpty()) Mode = 0;
        modelAndView.addObject("Mode",Mode);    // table data

        modelAndView.setViewName("faculty");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("model") Faculty faculty)
    {
        facultyService.saveOrUpdate(faculty);
        return adminView();
    }

    @RequestMapping(value = "/admin/remove/{modelId}", method = RequestMethod.GET)
    public ModelAndView remove(@RequestParam("modelId") String modelId)
    {
        facultyService.removeFaculty(modelId);
        return new ModelAndView("redirect:/faculty/admin");
    }

    @RequestMapping(value = "/admin/edit/{modelId}", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("modelId") String modelId)
    {
        ModelAndView modelAndView = new ModelAndView();

        int Mode = 2;
        modelAndView.addObject("Mode",Mode);

        int accessTypeFlag = 1; // admin access
        modelAndView.addObject("accessTypeFlag",accessTypeFlag);

        Faculty faculty = facultyService.getFacultyById(modelId);
        modelAndView.addObject("model",faculty);

        modelAndView.setViewName("faculty");
        return modelAndView;
    }
}
