using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebDB.Models;

namespace WebDB.DAO
{
    public class NganhDAO
    {
        private DBContext db = new DBContext();
        public List<Nganh> GetList()
        {
            return db.Nganhs.ToList();
        }

        public Nganh GetRow(int? id)
        {
            return (id == null) ? null : db.Nganhs.Find(id);

        }

        public int Add(Nganh entity)
        {
            db.Nganhs.Add(entity);
            return db.SaveChanges();
        }

        public int Update(Nganh entity)
        {

            db.Entry(entity).State = EntityState.Modified;
            return db.SaveChanges();
        }

        public int Delete(Nganh entity)
        {
            db.Nganhs.Remove(entity);
            return db.SaveChanges();
        }
    }
}
