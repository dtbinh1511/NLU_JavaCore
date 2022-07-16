using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Combox
{
    public partial class ComboBox : Form
    {
        public ComboBox()
        {
            InitializeComponent();
        }

        private void btnOrder_Click(object sender, EventArgs e)
        {
            int phone;
            try
            {
                phone = Int32.Parse(txtPhone.Text);
            }
            catch (FormatException)
            {
                txtPhone.BackColor = Color.Red;
                return;

            }

            String s = "Thông tin đặt hàng\n" + "Khách hàng: " + txtKH.Text + "\nĐiện thoại: " + phone + "\nSản phẩm đặt mua:\n";
            foreach (String line in listSP.SelectedItems)
            {
                s += "-"+line + "\n";
            }
            s += "Cách thanh toán:" + box.SelectedItem.ToString();
            txtR.Text = s;

        }
    }
}
