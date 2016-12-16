package knure;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI {
       
	private JFrame mainWindow;
	private boolean checkOnEdit = false;
	private int typeTransport = -1;
	private JTable table;
	private DefaultTableModel tableModel;
	private boolean haveTrailer = false;
	private ImageIcon haveTrailerIcon = new ImageIcon("havetrailer.png");
	private ImageIcon haveNoTrailerIcon = new ImageIcon("havenotrailer.png");
	private ImageIcon aboutIcon = new ImageIcon("about.png");
	private ImageIcon editIcon = new ImageIcon("edit.png");
	private ImageIcon findIcon = new ImageIcon("find.png");
	private ImageIcon deleteIcon = new ImageIcon("delete.png");
	private ImageIcon OKIcon = new ImageIcon("OK.png");
	private ImageIcon addIcon = new ImageIcon("add.png");
	private ImageIcon cancelIcon = new ImageIcon("Cancel.png");
	private MyListImpl list = new MyListImpl();
	
	public boolean checkStringInt(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
           if (string.length() == 1) {
              return false;
           }
           i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
	
	public boolean checkStringDouble(String string) {
		if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
           if (string.length() == 1) {
              return false;
           }
           i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
	
	public void showAddOrEditWindow(){
		JFrame addWindow = new JFrame("Добавление транспортного средства");
		addWindow.setResizable(false);
        ImageIcon shipIcon = new ImageIcon("ship.png");
        ImageIcon carIcon = new ImageIcon("car.png");
        ImageIcon truckIcon = new ImageIcon("truck.png");
		addWindow.setBounds(300, 100, 590, 500);
		addWindow.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		ButtonGroup bgButtonGroup = new ButtonGroup();
		JRadioButtonMenuItem buttonShip = new JRadioButtonMenuItem("Корабль", shipIcon);
		buttonShip.setBounds(10, 220, 120, 40);
		JRadioButtonMenuItem buttonPass = new JRadioButtonMenuItem("Пассажирский автомобиль", carIcon);
		buttonPass.setBounds(160, 220, 250, 40);
		JRadioButtonMenuItem buttonTruck = new JRadioButtonMenuItem("Грузовик",truckIcon);
		buttonTruck.setBounds(420, 220, 150, 40);
		bgButtonGroup.add(buttonShip);
		bgButtonGroup.add(buttonPass);
		bgButtonGroup.add(buttonTruck);
		p1.add(buttonShip);
		p1.add(buttonPass);
		p1.add(buttonTruck);
		
		JButton buttonOK = new JButton("OK", OKIcon);
		JButton buttonCancel = new JButton("Отмена", cancelIcon);
		buttonOK.setBounds(120, 430, 100, 20);
		buttonCancel.setBounds(320, 430, 130, 20);
		p1.add(buttonOK);
		p1.add(buttonCancel);
		
		JLabel labelName = new JLabel("Введите название ТС:");
		labelName.setBounds(20, 10, 200, 20);
		p1.add(labelName);
		JTextField fieldName = new JTextField();
		fieldName.setBounds(185, 12, 200, 20);
		p1.add(fieldName);
		
		JLabel labelType = new JLabel("Введите тип ТС");
		labelType.setBounds(20, 40, 200, 20);
		p1.add(labelType);
		JTextField fieldType = new JTextField();
		fieldType.setBounds(185, 42, 200, 20);
		p1.add(fieldType);
		
		JLabel labelPrice = new JLabel("Введите цену ТС ($):");
		labelPrice.setBounds(20, 70, 200, 20);
		p1.add(labelPrice);
		JTextField fieldPrice = new JTextField();
		fieldPrice.setBounds(185, 72, 200, 20);
		p1.add(fieldPrice);
		
		JLabel labelWeight = new JLabel("Введите вес ТС (кг):");
		labelWeight.setBounds(20, 100, 200, 20);
		p1.add(labelWeight);
		JTextField fieldWeight = new JTextField();
		fieldWeight.setBounds(185, 102, 200, 20);
		p1.add(fieldWeight);
		
		JLabel labeColor = new JLabel("Введите цвет ТС:");
		labeColor.setBounds(20, 130, 200, 20);
		p1.add(labeColor);
		String items[] = {"черный", "синий", "белый" , "зеленый", "красный", "желтый", "фиоленовый", "оранжевый", "голубой", "розовый"};
		JComboBox<String> comboBox = new JComboBox<String>();
		DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<String>(items);
		comboBox.setBounds(185, 132, 200, 20);
		comboBox.setModel(modelComboBox);
		p1.add(comboBox);
		
		JLabel labelPower = new JLabel("Введите мощность ТС (лс):");
		labelPower.setBounds(20, 160, 200, 20);
		p1.add(labelPower);
		JTextField fieldPower = new JTextField();
		fieldPower.setBounds(185, 162, 200, 20);
		p1.add(fieldPower);
		
		JLabel labelSelect = new JLabel("Выберите категорию транспортного средства:");
		labelSelect.setBounds(20, 190, 300, 20);
		p1.add(labelSelect);
		
		JLabel labelDisplacement = new JLabel("Введите водоизмещение корабля (л):");
		labelDisplacement.setBounds(20, 280, 250, 20);
		p1.add(labelDisplacement);
		JTextField fieldDisplacement = new JTextField();
		fieldDisplacement.setBounds(250, 282, 200, 20);
		p1.add(fieldDisplacement);
			
		JLabel labelTypeEngine = new JLabel("Введите тип двигателя корабля:");
		labelTypeEngine.setBounds(20, 310, 250, 20);
		p1.add(labelTypeEngine);
		JTextField fieldTypeEngine = new JTextField();
		fieldTypeEngine.setBounds(250, 312, 200, 20);
		p1.add(fieldTypeEngine);
			
		JLabel labelCapacity = new JLabel("Введите вместимость корабля (кг):");
		labelCapacity.setBounds(20, 340, 250, 20);
		p1.add(labelCapacity);
		JTextField fieldCapacity = new JTextField();
		fieldCapacity.setBounds(250, 342, 200, 20);
		p1.add(fieldCapacity);
			
		JLabel labelNumSeat = new JLabel("Введите количество сидений в автомобиле:");
		labelNumSeat.setBounds(20, 280, 350, 20);
		p1.add(labelNumSeat);
		JTextField fieldNumSeat = new JTextField();
		fieldNumSeat.setBounds(330, 282, 200, 20);
		p1.add(fieldNumSeat);
			
		JLabel labelSafetyClass = new JLabel("Введите класс безопасности автомобиля (число):");
		labelSafetyClass.setBounds(20, 310, 350, 20);
		p1.add(labelSafetyClass);
		JTextField fieldSafetyClass = new JTextField();
		fieldSafetyClass.setBounds(330, 312, 200, 20);
		p1.add(fieldSafetyClass);
		
		JLabel labelMaxCapacity = new JLabel("Введите грузоподъемность грузовика (кг):");
		labelMaxCapacity.setBounds(20, 280, 250, 20);
		p1.add(labelMaxCapacity);
		JTextField fieldMaxCapacity = new JTextField();
		fieldMaxCapacity.setBounds(280, 282, 200, 20);
		p1.add(fieldMaxCapacity);
			
		JLabel labelNumWeels = new JLabel("Введите количество осей грузовика:");
		labelNumWeels.setBounds(20, 310, 250, 20);
		p1.add(labelNumWeels);
		JTextField fieldNumWeels = new JTextField();
		fieldNumWeels.setBounds(280, 312, 200, 20);
		p1.add(fieldNumWeels);
		
		JLabel labelGear = new JLabel("Введите количество передач ТС");
		p1.add(labelGear);
		JTextField fieldGear = new JTextField();
		p1.add(fieldGear);		
		
		if(checkOnEdit){
			fieldName.setText(list.getByIndex(table.getSelectedRow() + 1).getName());
			fieldPrice.setText(Double.toString(list.getByIndex(table.getSelectedRow() + 1).getPrice()));
			fieldType.setText(list.getByIndex(table.getSelectedRow() + 1).getType());
			fieldWeight.setText(Double.toString(list.getByIndex(table.getSelectedRow() + 1).getWeight()));
			fieldPower.setText(Integer.toString(list.getByIndex(table.getSelectedRow() + 1).getPower()));
		}
		
		JLabel labelTrailer = new JLabel("Выберите наличие прицепа:");
		labelTrailer.setBounds(20, 370, 250, 20);
		p1.add(labelTrailer);
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem yesButton = new JRadioButtonMenuItem("Есть", haveTrailerIcon);
		yesButton.setBounds(280, 370, 100, 20);
		JRadioButtonMenuItem noButton = new JRadioButtonMenuItem("Нет", haveNoTrailerIcon, true);
		noButton.setBounds(400, 370, 100, 20);
		group.add(yesButton);
		group.add(noButton);
		p1.add(yesButton);
		p1.add(noButton);
		
		labelDisplacement.setVisible(false);
		fieldDisplacement.setVisible(false);
		labelTypeEngine.setVisible(false);
		fieldTypeEngine.setVisible(false);
		labelCapacity.setVisible(false);
		fieldCapacity.setVisible(false);
		labelNumSeat.setVisible(false);
		fieldNumSeat.setVisible(false);
		labelSafetyClass.setVisible(false);
		fieldSafetyClass.setVisible(false);
		labelMaxCapacity.setVisible(false);
		fieldMaxCapacity.setVisible(false);
		labelNumWeels.setVisible(false);
		fieldNumWeels.setVisible(false);
		labelGear.setVisible(false);
		fieldGear.setVisible(false);
		labelTrailer.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haveTrailer = true;
			}
		});
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haveTrailer = false;
			}
		});
		
//		if(checkOnEdit){
//			if(list.getByIndex(table.getSelectedRow() + 1).getClass().toString() == "ua.kture.kpp.Snytko.Demo.Ship"){
//				buttonShip.setSelected(true);
//				buttonPass.setEnabled(false);
//				buttonTruck.setEnabled(false);
//			}
//			if(list.getByIndex(table.getSelectedRow() + 1).getClass().toString() == "class ua.kture.kpp.Snytko.Demo.Passenger"){
//				buttonShip.setEnabled(false);
//				buttonPass.setSelected(true);
//				buttonTruck.setEnabled(false);
//			}
//			if(list.getByIndex(table.getSelectedRow() + 1).getClass().toString() == "class ua.kture.kpp.Snytko.Demo.Truck"){
//				buttonShip.setEnabled(false);
//				buttonPass.setEnabled(false);
//				buttonTruck.setSelected(true);
//			}
//		}
		
		buttonShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkOnEdit){
					fieldDisplacement.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[6].toString());
					fieldTypeEngine.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[8].toString());
					fieldCapacity.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[7].toString());
				}
				labelDisplacement.setVisible(true);
				fieldDisplacement.setVisible(true);
				labelTypeEngine.setVisible(true);
				fieldTypeEngine.setVisible(true);
				labelCapacity.setVisible(true);
				fieldCapacity.setVisible(true);
				labelNumSeat.setVisible(false);
				fieldNumSeat.setVisible(false);
				labelSafetyClass.setVisible(false);
				fieldSafetyClass.setVisible(false);
				labelMaxCapacity.setVisible(false);
				fieldMaxCapacity.setVisible(false);
				labelNumWeels.setVisible(false);
				fieldNumWeels.setVisible(false);
				labelType.setVisible(true);
				fieldType.setVisible(true);
				labelGear.setVisible(false);
				fieldGear.setVisible(false);
				labelTrailer.setVisible(false);
				yesButton.setVisible(false);
				noButton.setVisible(false);
				typeTransport = 0;
			
			}
		});	
		
		buttonPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkOnEdit){
					fieldGear.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[6].toString());
					fieldSafetyClass.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[7].toString());
					fieldNumSeat.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[8].toString());
				}
				labelDisplacement.setVisible(false);
				fieldDisplacement.setVisible(false);
				labelTypeEngine.setVisible(false);
				fieldTypeEngine.setVisible(false);
				labelCapacity.setVisible(false);
				fieldCapacity.setVisible(false);
				labelNumSeat.setVisible(true);
				fieldNumSeat.setVisible(true);
				labelSafetyClass.setVisible(true);
				fieldSafetyClass.setVisible(true);
				labelMaxCapacity.setVisible(false);
				fieldMaxCapacity.setVisible(false);
				labelNumWeels.setVisible(false);
				fieldNumWeels.setVisible(false);
				labelType.setVisible(true);
				fieldType.setVisible(true);
				labelGear.setVisible(true);
				labelGear.setBounds(20, 340, 250, 20);
				fieldGear.setVisible(true);
				fieldGear.setBounds(330, 342, 200, 20);
				labelTrailer.setVisible(false);
				yesButton.setVisible(false);
				noButton.setVisible(false);
				typeTransport = 1;				
			}
		});
		
		buttonTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkOnEdit){
					fieldGear.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[6].toString());
					fieldMaxCapacity.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[7].toString());
					fieldNumWeels.setText(list.getByIndex(table.getSelectedRow() + 1).toArray()[8].toString());
				}
				labelDisplacement.setVisible(false);
				fieldDisplacement.setVisible(false);
				labelTypeEngine.setVisible(false);
				fieldTypeEngine.setVisible(false);
				labelCapacity.setVisible(false);
				fieldCapacity.setVisible(false);
				labelNumSeat.setVisible(false);
				fieldNumSeat.setVisible(false);
				labelSafetyClass.setVisible(false);
				fieldSafetyClass.setVisible(false);
				labelMaxCapacity.setVisible(true);
				fieldMaxCapacity.setVisible(true);
				labelNumWeels.setVisible(true);
				fieldNumWeels.setVisible(true);
				labelType.setVisible(true);
				fieldType.setVisible(true);	
				labelGear.setVisible(true);
				labelGear.setBounds(20, 340, 250, 20);
				fieldGear.setVisible(true);
				fieldGear.setBounds(280, 342, 200, 20);
				labelTrailer.setVisible(true);
				yesButton.setVisible(true);
				noButton.setVisible(true);
				typeTransport = 2;
			}
		});
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				addWindow.setVisible(false);
			}
		});
		
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(typeTransport == -1){
					JOptionPane.showMessageDialog(null, "Выберите тип транспортного средства!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(fieldName.getText().equals("") || fieldType.getText().equals("") || fieldPower.getText().equals("")||
						fieldPrice.getText().equals("") || fieldWeight.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
						return;
				}	
				if (Double.parseDouble(fieldPrice.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "Не верно введена цена!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (Double.parseDouble(fieldWeight.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "Не верно введен вес!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (Integer.parseInt(fieldPower.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "Не верно введена мощность!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!checkOnEdit){
					switch(typeTransport){
					case 0 : {
						if(fieldCapacity.getText().equals("") || fieldDisplacement.getText().equals("") || 
								fieldTypeEngine.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldDisplacement.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Не верно введено водоизмещение корабля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Double.parseDouble(fieldCapacity.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Не верно введена вместимость корабля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						Ship ship = new Ship();
						ship.setName(fieldName.getText());
						ship.setType(fieldType.getText());
						ship.setWeight(Double.parseDouble(fieldWeight.getText()));
						ship.setPrice(Double.parseDouble(fieldPrice.getText()));
						ship.setPower(Integer.parseInt(fieldPower.getText()));
						ship.setColor(modelComboBox.getElementAt(comboBox.getSelectedIndex()));
						ship.setCapacity(Double.parseDouble(fieldCapacity.getText()));
						ship.setDisplacement(Double.parseDouble(fieldDisplacement.getText()));
						ship.setTypeEngine(fieldTypeEngine.getText());
						list.add(ship);
						tableModel.addRow(new String[] {ship.getName(),
														ship.getType(),
														ship.getColor(),
														Double.toString(ship.getPrice()),
														Integer.toString(ship.getPower())});
						addWindow.setVisible(false);
						return;
						}
					case 1 : {
						if(fieldNumSeat.getText().equals("") || fieldSafetyClass.getText().equals("") || 
								fieldGear.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
								return;
						}
						if (Integer.parseInt(fieldNumSeat.getText()) < 1) {
							JOptionPane.showMessageDialog(null, "Не верно введено количество сидений автомобиля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldSafetyClass.getText()) < 0 && Integer.parseInt(fieldPower.getText()) > 10) {
							JOptionPane.showMessageDialog(null, "Не верно введен класс безопасности автомобиля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldGear.getText()) < 2 && Integer.parseInt(fieldGear.getText()) > 20) {
							JOptionPane.showMessageDialog(null, "Не верно введенo количество передач!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						Passenger pass = new Passenger();
						pass.setName(fieldName.getText());
						pass.setType(fieldType.getText());
						pass.setWeight(Double.parseDouble(fieldWeight.getText()));
						pass.setPrice(Double.parseDouble(fieldPrice.getText()));
						pass.setPower(Integer.parseInt(fieldPower.getText()));
						pass.setColor(modelComboBox.getElementAt(comboBox.getSelectedIndex()));
						pass.setNumGears(Integer.parseInt(fieldGear.getText()));
						pass.setNumSeat(Integer.parseInt(fieldNumSeat.getText()));
						pass.setSafetyClass(Integer.parseInt(fieldSafetyClass.getText()));
						list.add(pass);
						tableModel.addRow(new String[] {pass.getName(),
														pass.getType(),
														pass.getColor(),
														Double.toString(pass.getPrice()),
														Integer.toString(pass.getPower())});
						addWindow.setVisible(false);
						return;
						}
					case 2 : {
						if(fieldMaxCapacity.getText().equals("") || fieldNumWeels.getText().equals("") || 
								fieldGear.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Double.parseDouble(fieldMaxCapacity.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Не верно введена грузоподъемность грузовика!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldNumWeels.getText()) < 2) {
							JOptionPane.showMessageDialog(null, "Не верно введено кличество осей грузовика!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						Truck truck = new Truck();
						truck.setName(fieldName.getText());
						truck.setType(fieldType.getText());
						truck.setWeight(Double.parseDouble(fieldWeight.getText()));
						truck.setPrice(Double.parseDouble(fieldPrice.getText()));
						truck.setPower(Integer.parseInt(fieldPower.getText()));
						truck.setColor(modelComboBox.getElementAt(comboBox.getSelectedIndex()));
						truck.setNumGears(Integer.parseInt(fieldGear.getText()));
						truck.setMaxCapacity(Integer.parseInt(fieldMaxCapacity.getText()));
						truck.setNumWeels(Integer.parseInt(fieldNumWeels.getText()));
						truck.setHaveTrailer(haveTrailer);
						list.add(truck);
						tableModel.addRow(new String[] {truck.getName(),
														truck.getType(),
														truck.getColor(),
														Double.toString(truck.getPrice()),
														Integer.toString(truck.getPower())});
						addWindow.setVisible(false);
						return;
						}
					}
				}
				if(checkOnEdit){
					int index = table.getSelectedRow();
					list.removeByIndex(table.getSelectedRow());
					tableModel.removeRow(table.getSelectedRow());
					switch(typeTransport){
					case 0 : {
						if(fieldCapacity.getText().equals("") || fieldDisplacement.getText().equals("") || 
								fieldTypeEngine.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldDisplacement.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Не верно введено водоизмещение корабля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Double.parseDouble(fieldCapacity.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Не верно введена вместимость корабля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						Ship ship = new Ship();
						ship.setName(fieldName.getText());
						ship.setType(fieldType.getText());
						ship.setWeight(Double.parseDouble(fieldWeight.getText()));
						ship.setPrice(Double.parseDouble(fieldPrice.getText()));
						ship.setPower(Integer.parseInt(fieldPower.getText()));
						ship.setColor(modelComboBox.getElementAt(comboBox.getSelectedIndex()));
						ship.setCapacity(Double.parseDouble(fieldCapacity.getText()));
						ship.setDisplacement(Double.parseDouble(fieldDisplacement.getText()));
						ship.setTypeEngine(fieldTypeEngine.getText());
						list.addByIndex(ship, index);
						tableModel.addRow(new String[] {ship.getName(),
														ship.getType(),
														ship.getColor(),
														Double.toString(ship.getPrice()),
														Integer.toString(ship.getPower())});
						addWindow.setVisible(false);
						return;
						}
					case 1 : {
						if(fieldNumSeat.getText().equals("") || fieldSafetyClass.getText().equals("") || 
								fieldGear.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
								return;
						}
						if (Integer.parseInt(fieldNumSeat.getText()) < 1) {
							JOptionPane.showMessageDialog(null, "Не верно введено количество сидений автомобиля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldSafetyClass.getText()) < 0 && Integer.parseInt(fieldPower.getText()) > 10) {
							JOptionPane.showMessageDialog(null, "Не верно введен класс безопасности автомобиля!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldGear.getText()) < 2 && Integer.parseInt(fieldGear.getText()) > 20) {
							JOptionPane.showMessageDialog(null, "Не верно введенo количество передач!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						Passenger pass = new Passenger();
						pass.setName(fieldName.getText());
						pass.setType(fieldType.getText());
						pass.setWeight(Double.parseDouble(fieldWeight.getText()));
						pass.setPrice(Double.parseDouble(fieldPrice.getText()));
						pass.setPower(Integer.parseInt(fieldPower.getText()));
						pass.setColor(modelComboBox.getElementAt(comboBox.getSelectedIndex()));
						pass.setNumGears(Integer.parseInt(fieldGear.getText()));
						pass.setNumSeat(Integer.parseInt(fieldNumSeat.getText()));
						pass.setSafetyClass(Integer.parseInt(fieldSafetyClass.getText()));
						list.addByIndex(pass, index);
						tableModel.addRow(new String[] {pass.getName(),
														pass.getType(),
														pass.getColor(),
														Double.toString(pass.getPrice()),
														Integer.toString(pass.getPower())});
						addWindow.setVisible(false);
						return;
						}
					case 2 : {
						if(fieldMaxCapacity.getText().equals("") || fieldNumWeels.getText().equals("") || 
								fieldGear.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Не все поля заполнены!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Double.parseDouble(fieldMaxCapacity.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Не верно введена грузоподъемность грузовика!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (Integer.parseInt(fieldNumWeels.getText()) < 2) {
							JOptionPane.showMessageDialog(null, "Не верно введено кличество осей грузовика!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
							return;
						}
						Truck truck = new Truck();
						truck.setName(fieldName.getText());
						truck.setType(fieldType.getText());
						truck.setWeight(Double.parseDouble(fieldWeight.getText()));
						truck.setPrice(Double.parseDouble(fieldPrice.getText()));
						truck.setPower(Integer.parseInt(fieldPower.getText()));
						truck.setColor(modelComboBox.getElementAt(comboBox.getSelectedIndex()));
						truck.setNumGears(Integer.parseInt(fieldGear.getText()));
						truck.setMaxCapacity(Integer.parseInt(fieldMaxCapacity.getText()));
						truck.setNumWeels(Integer.parseInt(fieldNumWeels.getText()));
						truck.setHaveTrailer(haveTrailer);
						list.addByIndex(truck, index);
						tableModel.addRow(new String[] {truck.getName(),
														truck.getType(),
														truck.getColor(),
														Double.toString(truck.getPrice()),
														Integer.toString(truck.getPower())});
						addWindow.setVisible(false);
						return;
						}
					}
					addWindow.setVisible(false);
					return;
				}
			}
		});

		addWindow.add(p1, BorderLayout.CENTER);
		addWindow.setVisible(true);
	}
	
	public void showMainWindow(){
	
		Transport t[] = new Transport[9];
		t[0] = new Truck("Man", "самосвал", 50000, "black", 320, 0, 0);
		t[1] = new Truck("Scania", "тягач", 60000.0, "white", 540, 40000, 12);
		t[2] = new Truck("Daf", "самосвал", 30000.0, "white", 380, 5000, 6);
		t[3] = new Passenger("Audi", "купе", 40000, "зелёный", 250, 9);
		t[4] = new Passenger("BMW", "седан", 55000, "синий", 380, 7);
		t[5] = new Passenger("Chevrolet", "джип", 30000, "красный", 250, 8);
		t[6] = new Ship("LBG", "танкер", 4000000, "чёрный", 50000000);
		t[7] = new Ship("BING", "круизный лайнер", 5500000, "синий", 380000);
		t[8] = new Ship("DFRY", "прогулочный катер", 300000, "красный", 10000);
		
		list.add(t[0]);
		list.add(t[1]);
		list.add(t[2]);
		list.add(t[3]);
		list.add(t[4]);
		list.add(t[5]);
		list.add(t[6]);
		list.add(t[7]);
		list.add(t[8]);

		
		mainWindow = new JFrame("Транспортные средства");
		mainWindow.setBounds(100, 100, 765, 450);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLayout(null);
		
		tableModel = new DefaultTableModel();
		table = new JTable();
		JScrollPane pane = new JScrollPane(table);
		table.setModel(tableModel);
		tableModel.addColumn("Название");
		tableModel.addColumn("Тип");
		tableModel.addColumn("Цвет");
		tableModel.addColumn("Цена");
		tableModel.addColumn("Мощность");
		table.changeSelection(table.getSelectedRow(), table.getSelectedColumn(), false, false);
		tableModel.isCellEditable(table.getSelectedRow(), table.getSelectedColumn());
		
//		mainWindow.addMouseListener(new MouseAdapter() {
//			public void MouseCliscked(MouseEvent e){
//				table.clearSelection();
//
//			}
//		});
		
		JButton del = new JButton("<html>Снять<p>выделение</html>");
		del.setBounds(625, 300, 115, 40);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
			}
		});
		mainWindow.add(del);
		
		for(int i = 0; i < list.getSize(); i++){
			tableModel.addRow(new String[] {list.getByIndex(i+1).getName(),
											list.getByIndex(i+1).getType(),
											list.getByIndex(i+1).getColor(),
											Double.toString(list.getByIndex(i+1).getPrice()),
											Integer.toString(list.getByIndex(i+1).getPower())});
		}
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBounds(10, 50, 600, 365);
		p.add(pane, BorderLayout.CENTER);
		
		JButton add = new JButton("Добавить", addIcon);
		add.setBounds(625, 50, 115, 25);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOnEdit = false;
				showAddOrEditWindow();
			}
		});
		
		JButton refactor = new JButton("Изменить", editIcon);
		refactor.setBounds(625, 90, 115, 25);
		refactor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOnEdit = true;
				if(table.getSelectedRow() < 0 || table.getSelectedRowCount() > 1){
					JOptionPane.showMessageDialog(null, "Выберите одну строку!");
					return;
				}
				showAddOrEditWindow();
			}
		});
		
		JButton delete = new JButton("Удалить", deleteIcon);	
		delete.setBounds(625, 130, 115, 25);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(table.getSelectedRow() < 0 || table.getSelectedRowCount() > 1){
					JOptionPane.showMessageDialog(null, "Выберите одну строку!");
					return;
				}
				Object[] options = { "Да", "Нет!" };
	            int n = JOptionPane.showOptionDialog(null, "Подтвердите удаление элемента", "Удаление", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	            if (n == 0) {
	                list.removeByIndex(table.getSelectedRow());
	                tableModel.removeRow(table.getSelectedRow());
	            }
			}
		});
		
		JLabel caption = new JLabel("Выберите категорию:");
		caption.setBounds(10, 10, 150, 20);
		caption.setFont(new Font(null, Font.BOLD, 12));
		
		String items[] = {"название", "цвет", "цена" , "тип", "мощность"};
		JComboBox<String> comboBox = new JComboBox<String>(items);
		DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<String>(items);
		comboBox.setModel(modelComboBox);
		comboBox.setBounds(155, 11, 130, 20);
		
		JLabel lWordSearch = new JLabel("Введите слово:");
		lWordSearch.setBounds(320, 10, 150, 20);
		lWordSearch.setFont(new Font(null, Font.BOLD, 12));
		
		JTextField fieldSearch = new JTextField();
		fieldSearch.setBounds(430, 11, 175, 20);
		
		JButton search = new JButton("Найти", findIcon);
		search.setBounds(625, 10, 115, 25);
		search.setFocusable(true);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == "название"){
					boolean check = false;
					for(int i = 0; i < list.getSize(); i++){
						if(fieldSearch.getText().equals(list.getByIndex(i + 1).getName())){
							table.setRowSelectionInterval(i, i);
							return;
						}
					}
					if(!check) {
						JOptionPane.showMessageDialog(null, "Запрашиваемого элемента не существует!");
						return;
					}
				}
				if(comboBox.getSelectedItem() == "цвет"){
					boolean check = false;
					for(int i = 0; i < list.getSize(); i++){
						if(fieldSearch.getText().equals(list.getByIndex(i + 1).getColor())){
							table.setRowSelectionInterval(i, i);
							return;
						}				
					}
					if(!check) {
						JOptionPane.showMessageDialog(null, "Запрашиваемого элемента не существует!");
						return;
					}
				}
				if(comboBox.getSelectedItem() == "цена"){
					boolean check = false;
					for(int i = 0; i < list.getSize(); i++){
						if(fieldSearch.getText().equals(Double.toString(list.getByIndex(i + 1).getPrice()))){
							table.setRowSelectionInterval(i, i);
							return;
						}				
					}
					if(!check) {
						JOptionPane.showMessageDialog(null, "Запрашиваемого элемента не существует!");
						return;
					}
				}
				if(comboBox.getSelectedItem() == "тип"){
					boolean check = false;
					for(int i = 0; i < list.getSize(); i++){
						if(fieldSearch.getText().equals(list.getByIndex(i + 1).getType())){
							table.setRowSelectionInterval(i, i);
							return;
						}				
					}
					if(!check) {
						JOptionPane.showMessageDialog(null, "Запрашиваемого элемента не существует!");
						return;
					}
				}
				if(comboBox.getSelectedItem() == "мощность"){
					boolean check = false;
					for(int i = 0; i < list.getSize(); i++){
						if(fieldSearch.getText().equals(Integer.toString(list.getByIndex(i + 1).getPower()))){
							table.setRowSelectionInterval(i, i);
							check = true;
							return;
						}
					}
					if(!check) {
						JOptionPane.showMessageDialog(null, "Запрашиваемого элемента не существует!");
						return;
					}
				}
			}
		});
		
		JButton allInfo = new JButton("<html>Доп.<p>информ.</html>", aboutIcon);
		allInfo.setBounds(625, 170, 115, 40);
		allInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0 || table.getSelectedRowCount() > 1){
					JOptionPane.showMessageDialog(null, "Выберите одну строку!");
					return;
				}
				else{
					JOptionPane.showMessageDialog(null, list.getByIndex(table.getSelectedRow() + 1).toString());
				}
			}
		});
		
		
		
		mainWindow.add(allInfo);
		mainWindow.add(search);
		mainWindow.add(fieldSearch);
		mainWindow.add(lWordSearch);
		mainWindow.add(comboBox);
		mainWindow.add(caption);
        mainWindow.add(add);
        mainWindow.add(refactor);
        mainWindow.add(delete);
		mainWindow.add(p);
		mainWindow.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		GUI ui = new GUI();
		ui.showMainWindow();
	}

}
