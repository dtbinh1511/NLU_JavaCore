namespace Combox
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtKH = new System.Windows.Forms.TextBox();
            this.txtPhone = new System.Windows.Forms.TextBox();
            this.listSP = new System.Windows.Forms.ListBox();
            this.label5 = new System.Windows.Forms.Label();
            this.box = new System.Windows.Forms.ComboBox();
            this.btnOrder = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.txtR = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(219, 38);
            this.label1.TabIndex = 0;
            this.label1.Text = "Form đặt hàng";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(15, 63);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Khách hàng";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(15, 92);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(55, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Điện thoại";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(15, 123);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(108, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "Danh sách sản phẩm";
            // 
            // txtKH
            // 
            this.txtKH.Location = new System.Drawing.Point(100, 56);
            this.txtKH.Name = "txtKH";
            this.txtKH.Size = new System.Drawing.Size(170, 20);
            this.txtKH.TabIndex = 4;
            // 
            // txtPhone
            // 
            this.txtPhone.Location = new System.Drawing.Point(100, 92);
            this.txtPhone.Name = "txtPhone";
            this.txtPhone.Size = new System.Drawing.Size(170, 20);
            this.txtPhone.TabIndex = 5;
            // 
            // listSP
            // 
            this.listSP.DisplayMember = "true";
            this.listSP.FormattingEnabled = true;
            this.listSP.Items.AddRange(new object[] {
            "Doraemon",
            "Kính Vạn Hoa",
            "Harry Potter"});
            this.listSP.Location = new System.Drawing.Point(18, 150);
            this.listSP.Name = "listSP";
            this.listSP.SelectionMode = System.Windows.Forms.SelectionMode.MultiSimple;
            this.listSP.Size = new System.Drawing.Size(252, 95);
            this.listSP.TabIndex = 6;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(15, 269);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(66, 13);
            this.label5.TabIndex = 7;
            this.label5.Text = "Thanh Toán";
            // 
            // box
            // 
            this.box.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.box.DisplayMember = "true";
            this.box.FormattingEnabled = true;
            this.box.Items.AddRange(new object[] {
            "ATM",
            "Tiền Mặt",
            "Chuyển Khoản"});
            this.box.Location = new System.Drawing.Point(18, 295);
            this.box.Name = "box";
            this.box.Size = new System.Drawing.Size(121, 21);
            this.box.TabIndex = 8;
            // 
            // btnOrder
            // 
            this.btnOrder.Location = new System.Drawing.Point(18, 347);
            this.btnOrder.Name = "btnOrder";
            this.btnOrder.Size = new System.Drawing.Size(75, 23);
            this.btnOrder.TabIndex = 9;
            this.btnOrder.Text = "Đặt hàng";
            this.btnOrder.UseVisualStyleBackColor = true;
            this.btnOrder.Click += new System.EventHandler(this.btnOrder_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(309, 56);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(101, 13);
            this.label6.TabIndex = 10;
            this.label6.Text = "Thông tin đơn hàng";
            // 
            // txtR
            // 
            this.txtR.Location = new System.Drawing.Point(310, 92);
            this.txtR.Name = "txtR";
            this.txtR.Size = new System.Drawing.Size(235, 257);
            this.txtR.TabIndex = 11;
            this.txtR.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(574, 386);
            this.Controls.Add(this.txtR);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnOrder);
            this.Controls.Add(this.box);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.listSP);
            this.Controls.Add(this.txtPhone);
            this.Controls.Add(this.txtKH);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Combo box";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtKH;
        private System.Windows.Forms.TextBox txtPhone;
        private System.Windows.Forms.ListBox listSP;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox box;
        private System.Windows.Forms.Button btnOrder;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.RichTextBox txtR;
    }
}

