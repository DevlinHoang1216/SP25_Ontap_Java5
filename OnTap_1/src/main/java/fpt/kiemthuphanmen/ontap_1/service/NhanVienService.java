package fpt.kiemthuphanmen.ontap_1.service;

import fpt.kiemthuphanmen.ontap_1.entity.NhanVien;
import fpt.kiemthuphanmen.ontap_1.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    
    public List<NhanVien> getNhanVienAll() {
        return nhanVienRepository.findAll();
    }
    
    public NhanVien getNhanVienById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVienById(Long id) {
        nhanVienRepository.deleteById(id);
    }

}
