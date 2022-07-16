namespace DateTimePicker
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
            this.timeTable = new System.Windows.Forms.DateTimePicker();
            this.txtDate = new System.Windows.Forms.TextBox();
            this.label = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // timeTable
            // 
            this.timeTable.CustomFormat = "";
            this.timeTable.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.timeTable.Location = new System.Drawing.Point(26, 34);
            this.timeTable.Margin = new System.Windows.Forms.Padding(10);
            this.timeTable.MaxDate = new System.DateTime(2050, 12, 31, 0, 0, 0, 0);
            this.timeTable.MinDate = new System.DateTime(1920, 1, 1, 0, 0, 0, 0);
            this.timeTable.Name = "timeTable";
            this.timeTable.Size = new System.Drawing.Size(266, 20);
            this.timeTable.TabIndex = 0;
            this.timeTable.Value = new System.DateTime(2021, 12, 30, 0, 0, 0, 0);
            this.timeTable.ValueChanged += new System.EventHandler(this.timeTable_ValueChanged);
            // 
            // txtDate
            // 
            this.txtDate.Location = new System.Drawing.Point(62, 93);
            this.txtDate.Name = "txtDate";
            this.txtDate.Size = new System.Drawing.Size(200, 20);
            this.txtDate.TabIndex = 1;
            // 
            // label
            // 
            this.label.AutoSize = true;
            this.label.Location = new System.Drawing.Point(23, 96);
            this.label.Name = "label";
            this.label.Size = new System.Drawing.Size(33, 13);
            this.label.TabIndex = 2;
            this.label.Text = "Date:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(345, 193);
            this.Controls.Add(this.label);
            this.Controls.Add(this.txtDate);
            this.Controls.Add(this.timeTable);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DateTimePicker timeTable;
        private System.Windows.Forms.TextBox txtDate;
        private System.Windows.Forms.Label label;
    }
}

