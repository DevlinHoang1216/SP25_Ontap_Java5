package fpt.kiemthuphanmen.ontap_1.controller;

import fpt.kiemthuphanmen.ontap_1.entity.ChucVu;
import fpt.kiemthuphanmen.ontap_1.entity.NhanVien;
import fpt.kiemthuphanmen.ontap_1.service.ChucVuService;
import fpt.kiemthuphanmen.ontap_1.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/nhan-vien/hien-thi")
    public String nhanVien(Model model,@ModelAttribute("nhanVien")NhanVien nhanVien ) {
       List<NhanVien> listNhanVien = nhanVienService.getNhanVienAll();
       model.addAttribute("listNhanVien", listNhanVien);
        List<ChucVu> listChucVu = chucVuService.getAllChucVu();
        model.addAttribute("listChucVu", listChucVu);
        return "form";
    }

    @GetMapping("/nhan-vien/remove/{id}")
    public String nhanVienRemove(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        nhanVienService.deleteNhanVienById(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/nhan-vien/save")
    public String save(Model model, @Valid @ModelAttribute("nhanVien") NhanVien nhanVien, Errors errors) {
        if (errors.hasErrors()) {
            List<NhanVien> listNhanVien = nhanVienService.getNhanVienAll();
            model.addAttribute("listNhanVien", listNhanVien);
            List<ChucVu> listChucVu = chucVuService.getAllChucVu();
            model.addAttribute("listChucVu", listChucVu);
            return "form";
        }
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
