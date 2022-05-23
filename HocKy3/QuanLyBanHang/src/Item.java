
public class Item {
	private String id;
	private String name;
	private String production;
	private Integer importedPrice; // giá nhập
	private Integer exportedPrice; // giá bán

	public Item(String id, String name, String production, Integer importedPrice, Integer exportedPrice) {
		super();
		this.id = id;
		this.name = name;
		this.production = production;
		this.importedPrice = importedPrice;
		this.exportedPrice = exportedPrice;
	}

	@Override
	public String toString() {
		return  ", name=" + name ;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public Integer getImportedPrice() {
		return importedPrice;
	}

	public void setImportedPrice(Integer importedPrice) {
		this.importedPrice = importedPrice;
	}

	public Integer getExportedPrice() {
		return exportedPrice;
	}

	public void setExportedPrice(Integer exportedPrice) {
		this.exportedPrice = exportedPrice;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		else {
			Item that = (Item) obj;
			return this.id.equals(that.id) && this.name.equals(that.name) && this.production.equals(that.production)
					&& this.importedPrice == that.importedPrice && this.exportedPrice == that.exportedPrice;
		}

	}
}
