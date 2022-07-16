using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace WebDB.Models
{
    public partial class DBContext : DbContext
    {
        public DBContext()
            : base("name=StrConnect")
        {
        }

        public virtual DbSet<Chi> Chis { get; set; }
        public virtual DbSet<Nganh> Nganhs { get; set; }
        public virtual DbSet<ThanhVien> ThanhViens { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<ThanhVien>()
                .Property(e => e.NgaySinh)
                .IsUnicode(false);

            modelBuilder.Entity<ThanhVien>()
                .Property(e => e.Anh)
                .IsUnicode(false);
        }
    }
}
