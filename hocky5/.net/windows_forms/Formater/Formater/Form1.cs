using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formater
{
    public partial class Form1 : Form
    {
        FontStyle fontStyle = FontStyle.Regular;
        public Form1()
        {
            InitializeComponent();
            this.chkBold.Tag = FontStyle.Bold;
            this.chkItalic.Tag = FontStyle.Italic;
            this.chkUnder.Tag = FontStyle.Underline;
            this.radRed.Tag = Color.Red;
            this.radBlack.Tag = Color.Black;
            this.radBlue.Tag = Color.Blue;
            this.radGreen.Tag = Color.Green;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            txtNhapTen.Focus();
            lblLapTrinh.Text = txtNhapTen.Text;
        }

        private void btnThoat_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Bạn muốn thoát không ?", "Thông báo..", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                Application.Exit();
                Dispose();
            }

        }

        private void radioButtons_CheckedChanged(object sender, EventArgs e)
        {           
            RadioButton radio = sender as RadioButton;
            Color color = (Color)radio.Tag;
            Color foreColor = radio.Checked ? color : Color.Red;
            lblLapTrinh.ForeColor = foreColor;
        }
        private void checkboxButtons_ChekcedChanged(object sender, EventArgs e)
        {
            CheckBox checkBox = sender as CheckBox;
            FontStyle CurrentFontStyle = (FontStyle)checkBox.Tag;
            fontStyle = checkBox.Checked ? fontStyle | CurrentFontStyle : fontStyle & ~CurrentFontStyle;
            lblLapTrinh.Font = new Font("Segoe UI", 10, fontStyle, GraphicsUnit.Point);
        }


    }
}
