package gmit;

public class JourneyMap 
{
	private Node jerusalem;
	
	public JourneyMap()
	{
		jerusalem = new Node("Jerusalem", 200);
		jerusalem.setTerrain(0.0f);
		jerusalem.setDanger(1.2f);
		
		Node alRal = new Node("Al-Ral", 180);
		alRal.setTerrain(0.2f);
		alRal.setDanger(0.7f);
		
		Node baytGhur = new Node("Bayt Ghur", 164);
		baytGhur.setTerrain(0.4f);
		baytGhur.setDanger(0.8f);
		
		Node ModiIn = new Node("Modi'in Makabim Re'ut", 138);
		ModiIn.setTerrain(0.3f);
		ModiIn.setDanger(1.0f);
		
		Node gizmo = new Node("Gizmo", 131);
		gizmo.setTerrain(0.3f);
		gizmo.setDanger(0.6f);
		
		Node mountHerzl = new Node("Mount Herzl", 134);
		mountHerzl.setTerrain(2.0f);
		mountHerzl.setDanger(0.5f);
		
		Node evenSpir = new Node("Even Sapir", 118);
		evenSpir.setTerrain(1.0f);
		evenSpir.setDanger(0.4f);
		
		Node tsuradasa = new Node("Tsur Hadasa", 106);
		tsuradasa.setTerrain(1.1f);
		tsuradasa.setDanger(0.8f);
		
		Node beitShemesh = new Node("Beit Shemesh", 90);
		beitShemesh.setTerrain(0.3f);
		beitShemesh.setDanger(0.7f);
		
		Node talShahar = new Node("Tal Shahar", 83);
		talShahar.setTerrain(0.3f);
		talShahar.setDanger(0.6f);
		
		Node yadBinyanmin = new Node("Yad Binyanmin", 57);
		yadBinyanmin.setTerrain(0.4f);
		yadBinyanmin.setDanger(0.3f);
		
		Node antiochCity = new Node("Antioch City", 47);
		antiochCity.setTerrain(0.3f);
		antiochCity.setDanger(0.9f);
		
		Node antiochPort = new Node("Antioch Port", 30);
		antiochPort.setTerrain(0.3f);
		antiochPort.setDanger(0.4f);
		
		Node limasso = new Node("Limasso", 7);
		limasso.setTerrain(1.0f);
		limasso.setDanger(0.2f);
		
		Node cyprus = new Node("Cyprus", 0);
		cyprus.setTerrain(0.8f);
		cyprus.setDanger(0.0f);
		cyprus.setGoalNode(true);
		
		Node baytEinun = new Node("Bayt Einun", 180);
		baytEinun.setTerrain(0.7f);
		baytEinun.setDanger(0.7f);
		
		Node hura = new Node("Hura", 163);
		hura.setTerrain(0.5f);
		hura.setDanger(0.7f);
		
		Node beerSheva = new Node("Be'er Sheva", 133);
		beerSheva.setTerrain(0.4f);
		beerSheva.setDanger(0.6f);
		
		Node ahuzam = new Node("Ahuzam", 123);
		ahuzam.setTerrain(0.0f);
		ahuzam.setDanger(0.0f);
		
		Node kiryatGat = new Node("Kiryat Gat", 106);
		kiryatGat.setTerrain(0.0f);
		kiryatGat.setDanger(0.0f);		
		
		jerusalem.addChildNode(alRal, 20);
		jerusalem.addChildNode(mountHerzl, 46);
		jerusalem.addChildNode(baytEinun, 20);
		
		alRal.addChildNode(baytGhur, 24);
		alRal.addChildNode(jerusalem, 20);
		
		baytGhur.addChildNode(ModiIn, 28);
		baytGhur.addChildNode(alRal, 24);
		
		ModiIn.addChildNode(gizmo, 7);
		ModiIn.addChildNode(talShahar, 14);
		
		mountHerzl.addChildNode(evenSpir, 16);
		mountHerzl.addChildNode(jerusalem, 46);
		
		evenSpir.addChildNode(tsuradasa, 12);
		evenSpir.addChildNode(baytEinun, 39);
		evenSpir.addChildNode(mountHerzl, 16);
		
		tsuradasa.addChildNode(beitShemesh, 16);
		tsuradasa.addChildNode(evenSpir, 12);
		
		beitShemesh.addChildNode(ahuzam, 7);
		beitShemesh.addChildNode(talShahar, 7);
		beitShemesh.addChildNode(ModiIn, 7);
		beitShemesh.addChildNode(tsuradasa, 16);
		
		talShahar.addChildNode(yadBinyanmin, 26);
		talShahar.addChildNode(gizmo, 14);
		talShahar.addChildNode(beitShemesh, 7);
		
		yadBinyanmin.addChildNode(antiochCity, 10);
		yadBinyanmin.addChildNode(talShahar, 26);
		
		antiochCity.addChildNode(antiochPort, 10);
		antiochCity.addChildNode(yadBinyanmin, 10);
		
		antiochPort.addChildNode(limasso, 32);
		antiochPort.addChildNode(antiochCity, 10);
		
		limasso.addChildNode(cyprus, 12);
		limasso.addChildNode(antiochPort, 32);
		
		cyprus.addChildNode(limasso, 12);
	}
	
	public Node getStartNode()
	{
		return jerusalem;
	}
}
