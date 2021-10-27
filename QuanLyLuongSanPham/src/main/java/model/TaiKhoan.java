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

	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + "]";
	}

}
