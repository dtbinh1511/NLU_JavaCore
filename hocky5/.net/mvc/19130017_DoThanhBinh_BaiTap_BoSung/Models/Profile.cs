namespace BT2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Profile")]
    public partial class Profile
    {
        [Key]
        [StringLength(255)]
        [EmailAddress(ErrorMessage = "The Email field is not a valid e-mail")]
        public string Email { get; set; }

        [StringLength(255)]
        [Compare("Email", ErrorMessage = "'ConfirmEmail' and 'Email' do not match ")]
        public string ConfirmEmail { get; set; }

        [Required(ErrorMessage = "The Age field is required!")]
        [Range(16, 65, ErrorMessage = "The field Age must be between 16 and 65")]
        public int? Age { get; set; }

        [Required(ErrorMessage = "The Salary field is required")]
        public int? Salary { get; set; }

        [CreditCard(ErrorMessage = "The CreditCard field is not a vaild credit card number")]
        public string CreditCard { get; set; }

        [Url(ErrorMessage = "The Website field is not a valid fully-quanlified http, https, or ftp url")]
        [StringLength(255)]
        public string Website { get; set; }

        [FileExtensions(ErrorMessage = "The field Photo is not format image")]
        [StringLength(255)]
        public string Photo { get; set; }

        //[RegularExpression(@"\d{5}-[A-Z]\d-((\d{4})|(\d{4}\d{2}))", ErrorMessage = "The field SaigonMotoNumber must match the regular expression '5\\d-[A-Z]\\d-((\\d{4})|(\\d{4}\\d{2}))'")]
        public int? SaigonMotoNumber { get; set; }

        [MinLength(255, ErrorMessage = "The field Description must be a string with a maximum length of 255")]
        public string Description { get; set; }
    }
}
