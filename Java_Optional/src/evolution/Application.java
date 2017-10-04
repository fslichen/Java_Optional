package evolution;

import java.util.Optional;

import evolution.pojo.Computer;
import evolution.pojo.SoundCard;
import evolution.pojo.Usb;

public class Application {
	public static void main(String[] args) {
		Computer computer = new Computer();
		SoundCard soundCard = new SoundCard();
		Usb usb = new Usb();
		usb.setVersion("2.0");
		soundCard.setUsb(usb);
		computer.setSoundCard(soundCard);
		Optional<Computer> optional = Optional.of(computer);
		optional.map(Computer::getSoundCard).map(SoundCard::getUsb).map(Usb::getVersion).ifPresent(System.out::println);
		String alternativeVersion = optional.map(Computer::getSoundCard).map(SoundCard::getUsb).map(Usb::getVersion).orElse("Unknown");
		System.out.println(alternativeVersion);
		Computer nullComputer = null;
		// ofNullable tolerates null value of null computer.
		String nullVersion = Optional.ofNullable(nullComputer).map(Computer::getSoundCard).map(SoundCard::getUsb).map(Usb::getVersion).orElse("Unknown");
		System.out.println(nullVersion);
		String filteredVersion = Optional.of(computer).map(Computer::getSoundCard).map(SoundCard::getUsb).filter(x -> x.getVersion().equals("2.0")).map(Usb::getVersion).orElse("Unknown");
		System.out.println(filteredVersion);
	}
}	
