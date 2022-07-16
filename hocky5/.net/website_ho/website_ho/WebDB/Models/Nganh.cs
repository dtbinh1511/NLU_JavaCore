namespace WebDB.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Nganh")]
    public partial class Nganh
    {
        [Key]
        public int Ma { get; set; }

        [StringLength(30)]
        public string Ten { get; set; }
    }
}
