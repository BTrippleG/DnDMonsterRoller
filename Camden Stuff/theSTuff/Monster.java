package theSTuff;

public class Monster {
	
	//public String slug;
	public String name;
	public String size;
	//public String type;
	//public String subtype;
	//public String group;
	//public String alignment;
	public int armor_class;
	//public String armor_desc;
	public int hit_points;
	public int strength;
	public int dexterity;
	public int constitution;
	public int intelligence;
	public int wisdom;
	public int charisma;
	public int perception;
	

	public Monster
	//inputs for monster constructor
		   (String name, 
			String size, 
			int armor_class,
			int hit_points,
			int strength,
			int dexterity,
			int constitution,
			int intelligence,
			int wisdom,
			int perception) 
		   
		   //assignment of values to the new monster
	{
		this.name = name;
		this.size = size;
		this.armor_class = armor_class;
		this.hit_points = hit_points;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.perception = perception;
	}

}
