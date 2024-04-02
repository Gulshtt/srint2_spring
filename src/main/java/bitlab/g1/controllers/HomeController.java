package bitlab.g1.controllers;

import bitlab.g1.entities.ApplicationRequest;
import bitlab.g1.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

  @Autowired
  private RequestRepository requestRepository;

  @GetMapping("/")
  public String allRequestsPage(Model model) {
    List<ApplicationRequest> requests = requestRepository.findAll(Sort.by("handled"));
    model.addAttribute("requests", requests);
    return "home";
  }

  @GetMapping("/new")
  public String newRequestsPage(Model model) {
    List<ApplicationRequest> requests = requestRepository.findByHandledFalse();
    model.addAttribute("requests", requests);
    return "home";
  }

  @GetMapping("/reviewed")
  public String reviewedRequestsPage(Model model) {
    List<ApplicationRequest> requests = requestRepository.findByHandledTrue();
    model.addAttribute("requests", requests);
    return "home";
  }

  @GetMapping("/add")
  public String addRequestPage() {
    return "add_requests";
  }

  @GetMapping(value = "/details/{requestId}")
  public String details(Model model, @PathVariable(name = "requestId") Long id){
    ApplicationRequest request = requestRepository.findById(id).orElse(null);
    model.addAttribute("request", request);
    return "details";
  }
}
