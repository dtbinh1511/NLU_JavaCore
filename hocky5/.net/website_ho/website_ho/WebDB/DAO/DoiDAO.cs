using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebDB.Models;
namespace WebDB.DAO
{
    public class DoiDAO
    {
        private DBContext db = new DBContext();
        public List<Doi> GetList()
        {
            return db.Dois.ToList();
        }

        public Doi GetRow(int? id)
        {
            return (id == null) ? null : db.Dois.Find(id);

        }

        public int Add(Doi entity)
        {
            db.Dois.Add(entity);
            return db.SaveChanges();
        }

        public int Update(Doi entity)
        {

            db.Entry(entity).State = EntityState.Modified;
            return db.SaveChanges();
        }

        public int Delete(Doi entity)
        {
            db.Dois.Remove(entity);
            return db.SaveChanges();
        }
    }
}
