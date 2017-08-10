1. General Step for OOD
  1). Analyze the use case -> API (Input and Output)
  2). Analyze the Class and relationships
    a) Vechicle, ParkingSpot, Level, ParkingLot
    b) relationships: i) Association
                      ii) Composition: represents the ownership between two classes (has a relationships)
                      iii) Inheritance
  3) First focus on public method (API), then complete the implementation

  pay attention to
  inner Class provide some control on some info in the class -> entrySet()
  update twice/ if update wrong, info consistency(单例)

  4) implementation in detail.
  API
  boolean hasSpot(Vechicle v);
  boolean park(Vechicle v);
  boolean leave(Vechicle v);

  ParkingLot, Level, ParkingSpot, Vechicle, Car, Truck
  public enum VechicleSize{
    Compact, Large
  }

  Complete Code

public enum VehicleSize {
	Compact(1),
	Large(2);
	private final int size;
	private VehicleSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return this.size;
	}
}

public abstract class Vehicle {
	public abstract int getSize();
}

public class Car extends Vehicle {
	@Override
	public int getSize() {
		return VehicleSize.Compact.getSize();
	}
}

public class Truck extends Vehicle {
	@Override
	public int getSize() {
		return VehicleSize.Large.getSize();
	}
}

class ParkingSpot {
	private final int size;
	private Vehicle currentVehicle;

	ParkingSpot (int size) {
		this.size = size;
	}

	boolean fit(Vehicle v) {
		return this.currentVehicle == null && this.size >= v.getSize();
	}
	void park(Vehicle v) {
		this.currentVehicle = v;
	}
	void leave() {
		this.currentVehicle = null;
	}
	Vehicle getCurrentVehicle() {
		return this.currentVehicle;
	}
}

class Level {
	private final List<ParkingSpot> spots;

	Level (int nums) {
		List<ParkingSpot> list = new ArrayList<>(nums);
		for (int i = 0; i < nums; i++) {
			if (i < nums / 2) {
				list.add(new ParkingSpot(VehicleSize.Compact.getSize()));
			} else {
				list.add(new ParkingSpot(VehicleSize.Large.getSize()));
			}
		}
		spots = Collections.unmodifiableList(list);
	}

	boolean hasSpot(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(v)) {
				return true;
			}
		}
		return false;
	}

	boolean park(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(v)) {
				spot.park(v);
				return true;
			}
		}
		return false;
	}

	boolean leave(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.getCurrentVehicle() == v) {
				spot.leave();
				return true;
			}
		}
		return false;
	}
}

public class ParkingLot {
	private final Level[] levels;

	public ParkingLot (int level, int numPerLevel) {
		levels = new Level[level];
		for (int i = 0; i < level; i++) {
			levels[i] = new Level(numPerLevel);
		}
	}

	public boolean hasSpot(Vehicle v) {
		for (Level l : levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}

	public boolean park(Vehicle v) {
		for (Level l : levels) {
			if (l.park(v)) {
				return true;
			}
		}
		return false;
	}

	public boolean leave(Vehicle v) {
		for (Level l : levels) {
			if (l.leave(v)) {
				return true;
			}
		}
		return false;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingLot lot = new ParkingLot(4, 10);
		List<Vehicle> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			final Vehicle v = i % 2 == 0 ? new Car() : new Truck();
			list.add(v);
			boolean hasSpot = lot.hasSpot(v);
			if (i < 40) {
				assert hasSpot;
				assert lot.park(v);
			} else {
				assert !hasSpot;
				assert !lot.park(v);
			}
		}
		assert list.size() == 50;
		int i = 0;
		for (Vehicle v : list) {
			assert i >= 40 || lot.leave(v);
			i++;
		}
		System.out.println("test passed");
	}
}

1. when using enum, we could set an attribute to use comparasion (like size), Enum constructor is private.
2. when build new field, we need to think about whether it is final
3. ParkingSpot -> Level -> ParkingLot the association it aggregation, so the method is also 套娃.
4. Java.Collections.unmodifiableList(java.util.List) 可把一个ArrayList变为immutable
5. Vehicle为什么需要public？
    因为它是API的input参数，会需要在任何地方能调用
    ParkingSpot 什么时候需要是public的？停车后需要返回停车位
