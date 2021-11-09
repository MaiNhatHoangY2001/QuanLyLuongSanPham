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
	private String tenNV;

	public TaiKhoan(String tenNV, String tenTK, String mk) {
		super();
		this.tenNV = tenNV;
		this.tenTaiKhoan = tenTK;
		this.matKhau = mk;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + ", tenNV="
				+ tenNV + "]";
	}

	
}
