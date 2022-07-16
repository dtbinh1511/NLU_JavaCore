using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace BT2.Models
{
    public partial class DBContext : DbContext
    {
        public DBContext()
            : base("name=StrConnect")
        {
        }

        public virtual DbSet<Profile> Profiles { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Profile>()
                .Property(e => e.Email)
                .IsUnicode(false);

            modelBuilder.Entity<Profile>()
                .Property(e => e.ConfirmEmail)
                .IsUnicode(false);

            modelBuilder.Entity<Profile>()
                .Property(e => e.CreditCard)
                .IsUnicode(false);

            modelBuilder.Entity<Profile>()
                .Property(e => e.Website)
                .IsUnicode(false);

            modelBuilder.Entity<Profile>()
                .Property(e => e.Photo)
                .IsUnicode(false);

            modelBuilder.Entity<Profile>()
                .Property(e => e.Description)
                .IsUnicode(false);
        }
    }
}
