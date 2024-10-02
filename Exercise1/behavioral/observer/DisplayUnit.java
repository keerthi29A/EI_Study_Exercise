
public class DisplayUnit implements Observer {
    private String unitName;

    public DisplayUnit(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public void update(float temperature) {
        System.out.println(unitName + " displaying temperature: " + temperature + "°C");
    }
}
