package fpt.kiemthuphanmen.ontap_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_nhan_vien")
    @NotBlank(message = "Mã Nhân Viên không được để trống")
    private String maNhanVien;

    @Column(name = "ho_ten")
    @NotBlank(message = "Tên Nhân Viên không được để trống")
    private String hoTen;

   @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh")
    @NotNull(message = "Giới tính không được để trống")
    private Boolean gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "0//d{9}", message = "Số điện thoại không hợp lệ")
    private String soDienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @NotNull(message = "Chức vụ không được để trống")
    @ManyToOne
    @JoinColumn(name = "id_chuc_vu",nullable = false)
    private ChucVu chucVu;

}
