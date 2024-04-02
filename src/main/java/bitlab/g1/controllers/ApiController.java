package bitlab.g1.controllers;

import bitlab.g1.entities.ApplicationRequest;
import bitlab.g1.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApiController {
    @Autowired
    private RequestRepository requestRepository;

    @PostMapping(value = "/addrequest")
    public String addRequest(@RequestParam(name = "username") String username,
                         @RequestParam(name = "courseName") String courseName,
                         @RequestParam(name = "commentary") String commentary,
                         @RequestParam(name = "phone") String phone){

        ApplicationRequest request = new ApplicationRequest();
        request.setUserName(username);
        request.setCourseName(courseName);
        request.setCommentary(commentary);
        request.setPhone(phone);
        request.setHandled(false);

        requestRepository.save(request);
        return "redirect:/";
    }

    @PostMapping(value = "/review")
    public String saveRequest(@RequestParam(name = "id") Long id){

        ApplicationRequest request = requestRepository.findById(id).orElse(null);

        if(request != null) {
            request.setHandled(true);
            requestRepository.save(request);
        }

        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteCar(@RequestParam(name = "id") Long id){
        requestRepository.deleteById(id);
        return "redirect:/";
    }
}
