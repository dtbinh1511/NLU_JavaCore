using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PictureBox
{
    public partial class PictureBox : Form
    {
        public PictureBox()
        {
            InitializeComponent();
            new ToolTip().SetToolTip(this.picTurnOn, "Click me to Turn Off the light, please");
            new ToolTip().SetToolTip(this.picTurnOff, "Click me to Turn On the light, please");
        }



        private void txtName_TextChanged(object sender, EventArgs e)
        {
            if (picTurnOn.Visible == false)
            {
                txtRes.Text = txtName.Text + ". Turn On the light, please";
            }
            else
            {
                txtRes.Text = txtName.Text + ". Turn Off the light, please";
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void picTurnOn_Click(object sender, EventArgs e)
        {
            if (picTurnOn.Visible == true)
            {
                picTurnOn.Visible = false;
                picTurnOff.Visible = true;
                txtName_TextChanged(sender, e);

            }
        }

        private void picTurnOff_Click(object sender, EventArgs e)
        {
            if (picTurnOff.Visible == true)
            {

                picTurnOff.Visible = false;
                picTurnOn.Visible = true;
                txtName_TextChanged(sender, e);
            }

        }
    }
}
