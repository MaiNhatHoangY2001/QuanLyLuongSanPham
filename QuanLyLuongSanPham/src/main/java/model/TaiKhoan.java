/**
 * Tài khoản
 * Ngày tạo: 20/10/2021
 * Nguoi tạo: Hoàng Văn Chinh
 * người tham gia chỉnh sửa, update : Minh Hùng
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {

	@Id
	private String tenTaiKhoan;
	@Column(columnDefinition = "varchar(30)")
	private String matKhau;

	@OneToOne
	@MapsId
	@JoinColumn(name = "tenTaiKhoan")
	private NhanVien nhanVien;
	

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String tenTK, String mk) {
		super();
		this.tenTaiKhoan = tenTK;
		this.matKhau = mk;
	}
	
	public TaiKhoan(NhanVien nhanVien,String matKhau ) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
		
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + "]";
	}
	

	
}
