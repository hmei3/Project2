//Template

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hmei.hibernate.entity.Author;
import com.hmei.hibernate.entity.Book;
import com.hmei.hibernate.entity.Computer;
import com.hmei.hibernate.entity.Specification;

public class Main {
	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
//insert below:



		tx.commit();
		session.close();
		sf.close();

	}
}

//Book1

		String description = "New York City, New Year’s weekend, 2001. Jillian Guthrie, a troubled young journalist, stumbles onto a tantalizing mystery: the same man, unaged, stands alongside Ulysses S. Grant, Theodore Roosevelt, and Gandhi in three different photographs spanning eighty-five years of history.\n"
				+ "\n"
				+ "In another part of town, Will—an enigmatic thirty-three-year-old of immense charm, wit, and intelligence—looks forward to the new year with hope and trepidation. Haunted by his secret past and shadowed by a dangerous stranger, he finds himself the object of an intense manhunt spearheaded by an ambitious Vatican emissary and an elderly former UN envoy named Hanna.\n"
				+ "\n"
				+ "During the next forty-eight hours, a catastrophic event unites Will, Jillian, and Hanna—and puts them in the crosshairs of a centuries-old international conspiracy. Together, the three must unravel an ancient curse that stretches back two millennia and beyond, and face a primal evil that threatens their lives and thousands more.\n"
				+ "\n"
				+ "Award-winning science-fiction mastermind Kenneth Johnson blends epic adventure, romance, and evocative drama into an intense supernatural thriller rooted in one of the great untold legends of human history.";
		
		Book book = new Book("The Man of Legends", description, 6.99, 100);
		Set<Author> set = new HashSet<>();
		Author author = new Author("Kenneth Johnson");
		session.save(author);
		set.add(author);
		book.setAuthors(set);
		book.setImage("/resources/images/books/The_Man_of_Legends.jpg");
		
		System.out.println(book.getImage());
		
		session.save(book);


//Book2

		String description = "International bestselling author Jeremy Robinson has been compared to both Matthew Reilly and Stephen King. In Forbidden Island, he brings the characters and plotting of the fastest paced thrillers together with mind-bending imaginative horrors. \n" + 
				" \n" + 
				"SEEKING TO CONTACT HUMANITY'S LOST TRIBE...\n" + 
				" \n" + 
				"On the precipice of a cliff, contemplating suicide, dishonorably discharged U.S. Army Ranger, Rowan Baer, is invited to provide security to a research team visiting the most dangerous island in the world--North Sentinel Island in the Sea of Bengal. Seeking redemption, he accepts.\n" + 
				" \n" + 
				"Living among Amazon rainforest tribes, eccentric Israeli anthropologist, Talia Mayer, is recruited to study the island's elusive inhabitants--the Sentinelese--who have resided on the tropical island since the dawn of mankind. Seeing the chance of a lifetime, she joins the team.\n" + 
				" \n" + 
				"On the run from his past, Palestinian linguist, Mahdi Barakat, is given little choice: join the expedition and make contact with the Sentinelese, or be left to face the men tracking him down. Afraid for his life, he finds safe harbor halfway around the world.\n" + 
				" \n" + 
				"As part of an expedition funded by the Indian government and supported by a local resort millionaire, the team struggles to make contact with the Sentinelese, a tribal people renowned for their violence, strange behavior, and mysterious ways. But when the expedition's yacht strikes a reef, and sinks, the team finds themselves stranded on an island few people have ever set foot on and survived, an island that they quickly discover is home to far more than primitive tribal people.\n" + 
				" \n" + 
				"...THEY UNCOVER THE VERY SOURCE OF EVIL.";
		
		Book book = new Book("Forbidden Island", description, 14.99, 200);
		Set<Author> set = new HashSet<>();
		Author author = new Author("Jeremy Robinson");
		session.save(author);
		set.add(author);
		book.setAuthors(set);
		book.setImage("/resources/images/books/Forbidden_Island.jpg");
		session.save(book);



//Book3
		String description = "\"A consistently exciting and never predictable series.\"--Associated Press\n" + 
				"\n" + 
				"When Grace Ozmian, the beautiful and reckless daughter of a wealthy tech billionaire, first goes missing, the NYPD assumes she has simply sped off on another wild adventure. Until the young woman's body is discovered in an abandoned warehouse in Queens, the head nowhere to be found.\n" + 
				"\n" + 
				"Lieutenant CDS Vincent D'Agosta quickly takes the lead. He knows his investigation will attract fierce scrutiny, so D'Agosta is delighted when FBI Special Agent A.X.L. Pendergast shows up at the crime scene assigned to the case. \"I feel rather like Brer Rabbit being thrown into the briar patch,\" Pendergast tells D'Agosta, \"because I have found you here, in charge. Just like when we first met, back at the Museum of Natural History.\"\n" + 
				"\n" + 
				"But neither Pendergast nor D'Agosta are prepared for what lies ahead. A diabolical presence is haunting the greater metropolitan area, and Grace Ozmian was only the first of many victims to be murdered . . . and decapitated. Worse still, there's something unique to the city itself that has attracted the evil eye of the killer.\n" + 
				"\n" + 
				"As mass hysteria sets in, Pendergast and D'Agosta find themselves in the crosshairs of an opponent who has threatened the very lifeblood of the city. It'll take all of Pendergast's skill to unmask this most dangerous foe-let alone survive to tell the tale.";
		
		Book book = new Book("City of Endless Night", description, 19.04, 1);
		
		Set<Author> set = new HashSet<>();
		Author author1 = new Author("Douglas Preston");
		Author author2 = new Author("Lincoln Child");
		session.save(author1);
		session.save(author2);
		set.add(author1);
		set.add(author2);
		book.setAuthors(set);
		
		book.setImage("/resources/images/books/City_of_Endless_Night.jpg");
		session.save(book);	

//Book4

		String description = "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.\n" + 
		"\n" + 
		"Noted software expert Robert C. Martin presents a revolutionary paradigm with Clean Code: A Handbook of Agile Software Craftsmanship . Martin has teamed up with his colleagues from Object Mentor to distill their best agile practice of cleaning code “on the fly” into a book that will instill within you the values of a software craftsman and make you a better programmer—but only if you work at it.\n" + 
		"\n" + 
		"What kind of work will you be doing? You’ll be reading code—lots of code. And you will be challenged to think about what’s right about that code, and what’s wrong with it. More importantly, you will be challenged to reassess your professional values and your commitment to your craft.\n" + 
		"\n" + 
		"Clean Code is divided into three parts. The first describes the principles, patterns, and practices of writing clean code. The second part consists of several case studies of increasing complexity. Each case study is an exercise in cleaning up code—of transforming a code base that has some problems into one that is sound and efficient. The third part is the payoff: a single chapter containing a list of heuristics and “smells” gathered while creating the case studies. The result is a knowledge base that describes the way we think when we write, read, and clean code.\n" + 
		"\n" + 
		"Readers will come away from this book understanding\n" + 
		"How to tell the difference between good and bad code\n" + 
		"How to write good code and how to transform bad code into good code\n" + 
		"How to create good names, good functions, good objects, and good classes\n" + 
		"How to format code for maximum readability\n" + 
		"How to implement complete error handling without obscuring code logic\n" + 
		"How to unit test and practice test-driven development\n" + 
		"This book is a must for any developer, software engineer, project manager, team lead, or systems analyst with an interest in producing better code.";
		
		Book book = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", description, 38.39, 10);
		
		Set<Author> set = new HashSet<>();
		Author author = new Author("Robert C. Martin");
		session.save(author);
		set.add(author);
		book.setAuthors(set);
		
		book.setImage("/resources/images/books/Clean_Code:_A_Handbook_of_Agile_Software_Craftsmanship.jpg");
		
		session.save(book);


//Book 5


		String description = "“Bone-chilling.” –Publishers Weekly (Starred Review)\n" + 
				"\n" + 
				"“One of the best in the series.” –Booklist (Starred Review)\n" + 
				"\n" + 
				"To save mankind’s future, the members of Sigma Force must make a devil’s bargain as they join forces with their most hated enemy to stop an ancient threat in this gripping adventure from #1 New York Times bestselling author James Rollins.\n" + 
				"\n" + 
				"Off the coast of Brazil, a team of scientists discovers a horror like no other, an island where all life has been eradicated, consumed, and possessed by a species beyond imagination. Before they can report their discovery, a mysterious agency attacks the group, killing them all, save one: an entomologist, an expert on venomous creatures, Professor Ken Matsui from Cornell University.\n" + 
				"\n" + 
				"Strangest of all, this inexplicable threat traces back to a terrifying secret buried a century ago beneath the National Mall: a cache of bones preserved in amber. The artifact was hidden away by a cabal of scientists—led by Alexander Graham Bell—to protect humankind. But they dared not destroy it, for the object also holds an astonishing promise for the future: the very secret of life after death.\n" + 
				"\n" + 
				"Yet nothing stays buried forever. An ancient horror— dormant in the marrow of those preserved bones—is free once more, nursed and developed into a weapon of incalculable strength and malignancy, ready to wreak havoc on an unsuspecting world.\n" + 
				"\n" + 
				"To stop its spread, Commander Grayson Pierce of Sigma Force must survive a direct attack on the island of Maui. To be there first has always been the core mission of Sigma Force, a covert team forged to be America’s front line against emerging threats. But this time, even Sigma may not be able to decipher the deadly mystery, one that traces back to the founding of the Smithsonian Institution.\n" + 
				"\n" + 
				"With each new discovery, the menace they hunt is changing, growing, spreading—adapting and surviving every attempt to stop it from reconquering a world it once ruled. And each transformation makes it stronger . . . and smarter.\n" + 
				"\n" + 
				"Running out of time and options, Commander Grayson Pierce will be forced to make an impossible choice. To eradicate this extinction-level threat and expose those involved, he will have to join forces with Sigma’s greatest enemy—the newly resurrected Guild—even it if means sacrificing one of his own.";
		
		Book book = new Book("The Demon Crown: A Sigma Force Novel (Sigma Force Novels)", description, 16.41, 20);
		
		Set<Author> set = new HashSet<>();
		Author author = new Author("James Rollins");
		session.save(author);
		set.add(author);
		book.setAuthors(set);
		
		book.setImage("/resources/images/books/The_Demon_Crown:_A_Sigma_Force_Novel_(Sigma_Force_Novels).jpg");
		session.save(book);


//Book 6

		String description = "In 1984 a doomsday vault was constructed on a remote island in the Arctic Ocean. Its purpose was to preserve Earth’s genetic history in the event of a global catastrophe. Now, decades later, a second vault has been uncovered. This one resting where no one ever expected. And the problem is…it’s not ours. Yet even more curious than the vault itself, is what lies inside. Seeds. Millions of seeds. Each with a genetic embryo untouched and perfectly preserved. Waiting. No one knows who built it. Or when. What we have managed to figure out is that whoever it was traveled an immense distance. For the sole purpose of hiding their genetic blueprints on Earth. But why? Now a small group of marine biologists and navy investigators have been assigned to find out. Before anyone else does. But Alison Shaw and John Clay are not prepared for what they are about to uncover. Beginning with the truth behind our own evolution.";
		
		Book book = new Book("Catalyst (Breakthrough)", description, 10.95, 40);
		
		Set<Author> set = new HashSet<>();
		Author author = new Author("Michael C. Grumley");
		session.save(author);
		set.add(author);
		book.setAuthors(set);
		
		book.setImage("/resources/images/books/Catalyst_(Breakthrough).jpg");
		session.save(book);


//Book 7

		String description = "Harry Potter has no idea how famous he is. That's because he's being raised by his miserable aunt and uncle who are terrified Harry will learn that he's really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright. From the surprising way he is greeted by a lovable giant, to the unique curriculum and colorful faculty at his unusual school, Harry finds himself drawn deep inside a mystical world he never knew existed and closer to his own noble destiny.";
		
		Book book = new Book("Harry Potter and the Sorcerer's Stone", description, 7.09, 200);
		
		Set<Author> set = new HashSet<>();
		Author author1 = new Author("J.K. Rowling");
		Author author2 = new Author("Mary GrandPré");
		session.save(author1);
		session.save(author2);
		set.add(author1);
		set.add(author2);
		book.setAuthors(set);
		
		book.setImage("/resources/images/books/Harry_Potter_and_the_Sorcerer's_Stone.jpg");
		session.save(book);



//Computer1

		String description = "15.6\" touch screen offers an easy view of images and videos at 1366 x 768 resolution and simplifies navigation of on-screen content. LED backlighting provides a thinner, more energy-efficient screen.\n" + 
				"8th Generation Quad Core Intel Core i7-8550U Processor 1.8GHz (Up to 4.0GHz with Turbo Boost) with 8 MB Cache\n" + 
				"16GB DDR4 SDRAM, 1TB SSD, Full Keyboard with 10-key numeric keyboard, Bluetooth\n" + 
				"802.11ac (1x1), 2 x USB 3.1, 1 x USB 2.0 , HDMI, 1 x RJ45, Multi-Format Digital Media Reader, Headphone/Microphone combo jack, HD Webcam\n" + 
				"Windows 10 brings back the Start Menu from Windows 7 and introduces new features, like the Edge Web browser that lets you markup Web pages on your screen.";
		
		Computer computer = new Computer(
				"2018 Flagship HP 15.6 Inch Flagship Touchscreen Laptop Computer (Intel Core i7-8550U 2.0GHz, 16GB DDR4 RAM, 1TB SSD, WiFi, Intel Graphics 620, DVD, HD Webcam, Windows 10) Black", description, 1049.00, 100);
		
		Specification spec = new Specification();
		spec.setRamSize("16 GB");
		spec.setProcessorManufacturer("Intel");
		spec.setProcessorCount("4");
		spec.setProcessorSpeed("1.8 GHz");
		spec.setDisplayResolutionMaximum("1366x768");
		spec.setScreenSize("15.6 in");
		spec.setHardDiskSize("1,000 GB");
		spec.setItemDimensions("14.95 x 9.99 x 0.94 in");
		spec.setItemWeight("4.3 lbs");
		spec.setOperatingSystem("Windows 10");
		spec.setWirelessCompatibility("802.11 A/C");
		spec.setGraphicsCoprocessor("Intel Graphics 620");
		spec.setGraphicsDescription("integrated");
		
		computer.setSpecification(spec);

        computer.setImage("/resources/images/computers/computer1.jpg");

		session.save(computer);

//Computer2

		String description = "7th Generation Intel Core i5-7400T Processor (Up to 3.0GHz)\n" + 
				"23.8\" Full HD Widescreen IPS LED Back-lit Touch Screen Display (1920 x 1080)\n" + 
				"12GB DDR4 Memory, 1TB 5400RPM Hard Drive. Processor Core : Quad-core (4 core) Wireless LAN Standard : IEEE 802.11ac\n" + 
				"802.11ac Wi-Fi, Wireless Keyboard & Mouse. Chipset : Intel H110 Express\n" + 
				"Windows 10 Home";
		
		Computer computer = new Computer(
				"Acer Aspire AIO Touch Desktop, 23.8\" Full HD Touch, Intel Core i5-7400T, 12GB DDR4, 1TB HDD, Windows 10 Home, AZ3-715-ACKi5", description, 657.23, 100);
		
		Specification spec = new Specification();
		spec.setRamSize("12 GB");
		spec.setProcessorSeries("Intel Core i5");
		spec.setProcessorManufacturer("Intel");
		spec.setProcessorCount("1");
		spec.setProcessorSpeed("2.4 GHz");
		spec.setDisplayResolutionMaximum("1920 x 1080");
		spec.setHardDiskSize("1,000 GB");
		spec.setItemDimensions("1.42 x 23.34 x 18.45 in");
		spec.setItemWeight("22.6 pounds");
		spec.setOperatingSystem("Windows 10");
		spec.setGraphicsCoprocessor("Intel 630");
		spec.setGraphicsDescription("integrated");

		
		computer.setSpecification(spec);

        computer.setImage("/resources/images/computers/Acer_Aspire_AIO_Touch_Desktop,_23.8\"_Full_HD_Touch,_Intel_Core_i5-7400T,_12GB_DDR4,_1TB_HDD,_Windows_10_Home,_AZ3-715.jpg");

		session.save(computer);


//Computer 3
		
		String description = "GR8 II-T044Z mini PC gaming desktop with Windows 10 features a 7th Generation Intel Core i5-7400 processor with 8GB DDR4 memory, 802.11ac Wifi and 1TB HDD for full desktop power from a console sized system\n" + 
				"NVIDIA VR Ready with customized ASUS GeForce GTX 1060 graphics for unstoppable HD gaming and 4K streaming\n" + 
				"AURA Sync RGB lighting features an endless spectrum of colors with the ability to synchronize effects across an ever-expanding ecosystem of AURA Sync enabled products like Claymore keyboards and Gladius mice\n" + 
				"Ultra-quiet thermal chamber design provides optimized cooling for everyday use and actively cools during marathon gaming sessions - up to 23% quieter than similar systems\n" + 
				"SupremeFX HD Audio including Sonic Studio III and Sonic Radar III for immersive in-game sound. Wireless Data Network: 802.11 a/b/g/n/ac2 x2 , Bluetooth V4.2";
		
		Computer computer = new Computer(
				"ASUS GR8 II-T044Z VR Ready Mini PC Gaming Desktop with Intel Core i5-7400 and GeForce GTX 1060", description, 849.99, 100);
		
		Specification spec = new Specification();
		spec.setRamSize("8 GB");
		spec.setProcessorSeries("Intel Core i5");
		spec.setProcessorManufacturer("Intel");
		spec.setProcessorCount("4");
		spec.setProcessorSpeed("3.5 GHz");
//		spec.setDisplayResolutionMaximum("1920 x 1080");
		spec.setHardDiskSize("1000 GB Mechanical Hard Drive");
		spec.setItemDimensions("11 x 3.4 x 11.7 inches");
		spec.setItemWeight("8.8 pounds");
		spec.setOperatingSystem("Windows 10");
		spec.setGraphicsCoprocessor("geforce gtx");
		spec.setGraphicsDescription("Dedicated");
		spec.setWirelessCompatibility("802.11B, 802.11G, 802.11n");
//		spec.setHardDiskDescription(hardDiskDescription);
//		spec.setScreenSize(screenSize);

		
		computer.setSpecification(spec);

        computer.setImage("/resources/images/computers/ASUS_GR8_II-044Z_VR_Ready_Mini_PC_Gaming_Desktop_with_Intel_Core_i5-7400_and_GeForce_GTX_1060.jpg");

		session.save(computer);


//Computer 4

		String description = "System: Intel i7-7700K 4.2GHz Quad-Core | Intel B250 Chipset | 16GB DDR4 | 120GB SSD | 2TB HDD | Genuine Windows 10 Home 64-bit\n" + 
				"Graphics: NVIDIA GTX 1050 Ti 4GB Video Card | 1X DVI | 1x HDMI | 1X Display Port\n" + 
				"Connectivity: 6x USB 3.0 | 4x USB 2.0 Ports | 1x RJ-45 Network Ethernet 10/100/1000 | Audio: 7.1 Channel | Keyboard and Mouse\n" + 
				"Special Feature: Liquid Cooling | Tempered Glass Side Case Panel | RGB 7 Colors Gaming Keyboard\n" + 
				"Warranty: 1 Year Parts & Labor Warranty | Free Lifetime Tech Support";
		
		Computer computer = new Computer(
				"CYBERPOWERPC Gamer Xtreme Liquid Cool GLC2420 Desktop Gaming PC (Intel i7-7700K 4.2GHz, NVIDIA GTX 1050 Ti 4GB, 16GB DDR4 RAM, 120GB SSD, 2TB HDD, Win 10 Home), Black", description, 3688.00, 100);
		
		Specification spec = new Specification();
		spec.setRamSize("16 GB");
		spec.setProcessorSeries("Intel i7-7700K");
		spec.setProcessorManufacturer("Intel");
		spec.setProcessorCount("4");
		spec.setProcessorSpeed("4.2GHz");
//		spec.setDisplayResolutionMaximum("1920 x 1080");
		spec.setHardDiskSize("2,048 GB");
		spec.setItemDimensions("8.4 x 18.8 x 19.6 in");
		spec.setItemWeight("32 lbs");
		spec.setOperatingSystem("Windows 10");
		spec.setGraphicsCoprocessor("NVIDIA GTX 1050 Ti ");
		spec.setGraphicsDescription("Dedicated");
//		spec.setWirelessCompatibility("802.11B, 802.11G, 802.11n");
		spec.setHardDiskDescription("120GB SSD, 2TB HDD");
//		spec.setScreenSize(screenSize);

		
		computer.setSpecification(spec);

        computer.setImage("/resources/images/computers/CYBERPOWERPC_Gamer_Xtreme_Liquid_Cool_GLC2420_Desktop_Gaming_PC_(Intel_i7-7700K_4.2GHz,_NVIDIA_GTX_1050_Ti_4GB,_16GB_DDR4_RAM,_120GB_SSD,_2TB_HDD,_Win_10_Home),_Black.jpg");

		session.save(computer);


//Toy 1

		String description = "Diecast Model\n" + 
				"Ships Factory Sealed.\n" + 
				"As pictured";
		
		Toy toy = new Toy(
				"Coach Bus, White - Kinsmart 7101DW - 7\" Diecast Model Toy Car", description, 8.25, 100);
		
		toy.setCompany("Kinsmart");

        toy.setImage("/resources/images/toys/Coach_Bus,_White_-_Kinsmart_7101DW_- 7&quot;_Diecast_Model_Toy_Car.jpg");

		session.save(toy);

//Toy 2

		String description = "The intelligent NXT Lego brick features 32-bit microprocessor, a large matrix display\n" + 
				"Three interactive servo motors; four sensors(Ultrasonic Sensor, 2 Touch Sensors and the all-new Color Sensor)\n" + 
				"Color Sensor has triple functionality: Distinguishes colors and light settings, and functions as a lamp\n" + 
				"Easy-to-use software (PC and Mac) with icon-based drag-and-drop programming and 16 fun building and programming challenges\n" + 
				"Batteries not included with this product\n" + 
				"Building instructions for 4 new amazing robots\n" + 
				"Four input and 3 output ports, and Bluetooth and USB communication link";
		
		Toy toy = new Toy(
				"LEGO Mindstorms NXT 2.0 (8547) (Discontinued by manufacturer)", description, 549.40, 100);
		
		toy.setCompany("LEGO");

        toy.setImage("/resources/images/toys/LEGO_Mindstorms_NXT_2.0_(8547)_(Discontinued_by_manufacturer).jpg");

		session.save(toy);


//Toy 3

		String description = "Quantity:1Set-----match it spelling leap start interactive learning system for kindergarten 1st grade wooden educational toys magnetic art easel animals puzzle games for kids touch teach word book frustration free packaging my first microscope busy learners activity cube wooden magnetic maze educational toys dry erase easel board puzzles games for kids little apps tablet, pink lake union lodge ages 3 preschool educational toy\n" + 
				"Non-toxic finishes and child-safe wood materials -----magnetic blocks building set for kids, magnetic tiles educational building construction toys for boys and girls with storage bag magnetic blocks stem educational toys magnet building block tiles set for boys and girls hide n' tweet eggs chirping squeaky eggs educational toys, learning toys, preschool toys for toddlers usa map floor puzzle sit-to-stand learning walker frustration free packaging\n" + 
				"This product aims at training kids imagination, eye-hand coordination and color & shape recognition\n" + 
				"Ages 3 years to 5 years. -----Magnetic Drawing Board Mini Travel Doodle, Erasable Writing Sketch Colorful Pad Area Educational Learning Toy For Kid Toddlers Babies Green Wooden Toysmagnetic Drawing Board Double Side Multifunctional Jigsaw Puzzle Educational Toy Set Learning Game For Kids Boys Girls Over 3 Years Old Button Art Color Matching Mosaic Pegboard Set Early Learning Educational Toys For Kids Little Hands Ready Set School\n" + 
				"Easy to storage: A free iron box for easy storage.";
		
		Toy toy = new Toy(
				"Wooden Toys Magnetic Puzzles Kids Wooden Games Education Learning Toys For children", description, 2.99, 100);
		
		toy.setCompany("Shybuy Toys");

        toy.setImage("/resources/images/toys/Wooden_Toys_Magnetic_Puzzles_Kids_Wooden_Games_Education_Learning_Toys_For_children.jpg");

		session.save(toy);

//Grocery 1

		String description = "Pack of twelve, 12 FL OZ per can; Coca-Cola\n" + 
				"Coca-Cola is the most popular and biggest-selling soft drink in history, as well as the best-known brand in the world\n" + 
				"Best served chilled at 37 degrees; 34mg caffeine per can\n" + 
				"Perfect size for drinking with meals, on the go, or any time\n" + 
				"Created in 1886 in Atlanta, Georgia, by Dr. John S. Pemberton, Coca-Cola was first offered as a fountain beverage at Jacob's Pharmacy by mixing Coca-Cola syrup with carbonated water";
		
		Grocery grocery = new Grocery(
				"Coca-Cola Fridge Pack Cans, 12 Count, 12 fl oz", description, 4.88, 100);
		
		grocery.setIngredients("Carbonated Water, High Fructose Corn Syrup, Caramel Color, Phosphoric Acid, Natural Flavors, Caffeine.");
		grocery.setDirections("The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
		grocery.setImage("/resources/images/groceries/Coca-Cola_Fridge_Pack_Cans,_12_Count,_12_fl_oz.jpg");

		session.save(grocery);

//Grocery 2

		String description = "Sourced From Fresh Coconuts for Added Potency - Our oil is sourced from coconuts grown in the fertile volcanic soil of the Philippines. The soil imbues our oil with compounds that support skin, hair, and immunity.\n" + 
				"Purest Form Preserves Nutrients - Each jar is unrefined, organic, and cold-pressed in order to preserve MCTs, silky texture, and pleasant tropical aroma of the coconut.\n" + 
				"Packed With MCTs for Weight Management - The MCTs in coconut oil help your body burn up adipose (fatty) tissue by increasing the efficiency of your metabolism. Each serving of our coconut oil is bursting with these powerful, weight-fighting compounds\n" + 
				"Natural Fungus Fighter - The properties of coconut oil help fight candida and yeast, promoting skin and digestion support. You’ll have a happy gut in no time!\n" + 
				"Coconut Oil has a melting point at 76°F and may ship to you in solid or liquid form. It is still safe to consume if it is liquid or solid, free of Pesticides, Bleach, Hexanes and Trans Fats";
		
		Grocery grocery = new Grocery(
				"Viva Naturals Organic Extra Virgin Coconut Oil, 16 Ounce", description, 10.79, 100);
		
		grocery.setIngredients("100% Organic, extra-virgin, cold-pressed coconut oil.");
		grocery.setDirections("For Dietary Supplementation: Take 1-4 tablespoons per day for best results. For Cooking and Baking: Excellent for cooking up to 350° F (177°C) and makes an excellent dairy-free substitute for butter in baking. For Skin & Hair Care: For skin care, apply topically as an intensive moisturizing lotion. For use an intensive hair mask, submerge the coconut oil jar in warm water until liquefied. Apply 1 tablespoon to dry hair and let sit for 1-2 hours, shampooing thoroughly afterwards.");
		grocery.setImage("/resources/images/groceries/Coca-Cola_Fridge_Pack_Cans,_12_Count,_12_fl_oz.jpg");

		session.save(grocery);


//Grocery 3

		String description = "Brought to you by Whole Foods Market\n" + 
				"Unbleached and enriched with vitamins and minerals\n" + 
				"Milled for baking quality and consistency\n" + 
				"The ideal choice for all your recipes that call for flour";
		
		Grocery grocery = new Grocery(
				"365 Everyday Value, All-Purpose Flour, 5 lb", description, 3.29, 100);
		
		grocery.setIngredients("UNBLEACHED ENRICHED WHEAT FLOUR, NIACIN, REDUCED IRON, THIAMINE MONONITRATE, RIBOFLAVIN, FOLIC ACID.");
		grocery.setDirections("—");
		grocery.setImage("/resources/images/groceries/365_Everyday_Value,_All-Purpose_Flour,_5_lb.jpg");

		session.save(grocery);			
