namespace WebDB.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ThanhVien")]
    public partial class ThanhVien
    {
        [Key]
        public int Ma { get; set; }

        [StringLength(20)]
        public string HoTen { get; set; }

        [StringLength(50)]
        public string TenThuongGoi { get; set; }

        public string DiaChi { get; set; }

        public bool? GioiTinh { get; set; }

        [StringLength(1)]
        public string NgaySinh { get; set; }

        [StringLength(100)]
        public string NoiSinh { get; set; }

        public int? TinhTrang { get; set; }

        public int? SapXep { get; set; }

        [StringLength(100)]
        public string Anh { get; set; }

        [StringLength(30)]
        public string VaiTro { get; set; }

        public int? Chi { get; set; }

        public int? Nganh { get; set; }

        public int? Doi { get; set; }

        public string MoTa { get; set; }

        [StringLength(1)]
        public string NgayMat { get; set; }

        [StringLength(30)]
        public string QuanHe { get; set; }

        public int? MaQuanHe { get; set; }
    }
}
