using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebDB.Models;

namespace WebDB.DAO
{
    public class ThanhVienDAO
    {
        private DBContext db = new DBContext();
        public List<ThanhVien> GetList()
        {
            return db.ThanhViens.ToList();
        }

        public ThanhVien GetRow(int? id)
        {
            return (id == null) ? null : db.ThanhViens.Find(id);

        }     

        public int Add(ThanhVien entity)
        {
            db.ThanhViens.Add(entity);
            return db.SaveChanges();
        }

        public int Update(ThanhVien entity)
        {

            db.Entry(entity).State = EntityState.Modified;
            return db.SaveChanges();
        }

        public int Delete(ThanhVien entity)
        {
            db.ThanhViens.Remove(entity);
            return db.SaveChanges();
        }


    }
}
