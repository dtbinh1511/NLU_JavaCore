namespace PictureBox
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.picTurnOff = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtRes = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.picTurnOn = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.picTurnOff)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picTurnOn)).BeginInit();
            this.SuspendLayout();
            // 
            // picTurnOff
            // 
            this.picTurnOff.Image = global::PictureBox.Properties.Resources.tat;
            this.picTurnOff.ImageLocation = "";
            this.picTurnOff.Location = new System.Drawing.Point(91, 74);
            this.picTurnOff.Name = "picTurnOff";
            this.picTurnOff.Size = new System.Drawing.Size(170, 193);
            this.picTurnOff.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picTurnOff.TabIndex = 0;
            this.picTurnOff.TabStop = false;
            this.picTurnOff.Click += new System.EventHandler(this.picTurnOff_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(27, 38);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(49, 17);
            this.label1.TabIndex = 1;
            this.label1.Text = "Name:";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(91, 35);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(220, 20);
            this.txtName.TabIndex = 2;
            this.txtName.TextChanged += new System.EventHandler(this.txtName_TextChanged);
            // 
            // txtRes
            // 
            this.txtRes.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtRes.Location = new System.Drawing.Point(30, 308);
            this.txtRes.Name = "txtRes";
            this.txtRes.ReadOnly = true;
            this.txtRes.Size = new System.Drawing.Size(281, 20);
            this.txtRes.TabIndex = 4;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(236, 373);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 5;
            this.button1.Text = "Exit";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // picTurnOn
            // 
            this.picTurnOn.Image = global::PictureBox.Properties.Resources.bat;
            this.picTurnOn.Location = new System.Drawing.Point(91, 74);
            this.picTurnOn.Name = "picTurnOn";
            this.picTurnOn.Size = new System.Drawing.Size(170, 193);
            this.picTurnOn.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picTurnOn.TabIndex = 6;
            this.picTurnOn.TabStop = false;
            this.picTurnOn.Visible = false;
            this.picTurnOn.Click += new System.EventHandler(this.picTurnOn_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.SkyBlue;
            this.ClientSize = new System.Drawing.Size(330, 418);
            this.Controls.Add(this.picTurnOn);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.txtRes);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.picTurnOff);
            this.Name = "Form1";
            this.Text = "Picture Box";
            ((System.ComponentModel.ISupportInitialize)(this.picTurnOff)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picTurnOn)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox picTurnOff;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtRes;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.PictureBox picTurnOn;
    }
}

