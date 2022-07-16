using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebDB.Models;


namespace WebDB.DAO
{
    public class ChiDAO
    {
        private DBContext db = new DBContext();
        public List<Chi> GetList()
        {
            return db.Chis.ToList();
        }

        public Chi GetRow(int? id)
        {
            return (id == null) ? null : db.Chis.Find(id);

        }

        public int Add(Chi entity)
        {
            db.Chis.Add(entity);
            return db.SaveChanges();
        }

        public int Update(Chi entity)
        {

            db.Entry(entity).State = EntityState.Modified;
            return db.SaveChanges();
        }

        public int Delete(Chi entity)
        {
            db.Chis.Remove(entity);
            return db.SaveChanges();
        }
    }
}
