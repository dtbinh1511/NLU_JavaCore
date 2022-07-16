using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Order
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            int phone;
            try
            {
                 phone= Int32.Parse(txtPhone.Text);
            }
            catch (FormatException)
            {
                txtPhone.BackColor= Color.Red;
                return;

            }
            
            String s = "Thông tin đặt hàng\n" + "Khách hàng: " + txtKH.Text + "\nĐiện thoại: " + phone + "\nSản phẩm đặt mua:\n";
            foreach(String line in listSP.SelectedItems)
            {
                s+= line+"\n";
            }
            txtR.Text = s;
        }

    }
}
