package fpt.kiemthuphanmen.ontap_1.service;

import fpt.kiemthuphanmen.ontap_1.entity.ChucVu;
import fpt.kiemthuphanmen.ontap_1.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;

   public List<ChucVu> getAllChucVu(){
       return chucVuRepository.findAll();
   }
}
