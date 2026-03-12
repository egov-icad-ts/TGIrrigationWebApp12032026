package in.ts.icad.project.graphs;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import in.ts.icad.leagal.model.Canal;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentLineSegment;
import in.ts.icad.leagal.model.LineSegment;

/*This class is used to generate co-ordinates dynamically to build canal line diagram in jsp using svg tags*/
public class ComponentStructureCoordinates {

	public static List<ComponentLineSegment> getImages(List<Component> compList, String projectName) throws ParseException {

		List<ComponentLineSegment> compcords = new ArrayList<ComponentLineSegment>();

		List<Component> mainComp = new ArrayList<Component>();
		for (Component c : compList)
			if (c.getParentComponentId() == compList.get(0).getParentComponentId())
                                      mainComp.add(c);
			else
				break;

		List<Component> comps = new ArrayList<Component>();
		for (Component c : mainComp) {
			comps = new ArrayList<Component>();
			comps.add(c);
			comps = getAllComponents(c, compList, comps, compList.get(0).getComponentLevelId());
			// System.out.println(canals);
			comps = getDirections(comps);
		}
		List<ComponentLineSegment> compsegments = new ArrayList<ComponentLineSegment>();
		for (Component c : comps) {
			compsegments = getSegments(c, compsegments, comps);
		}
		try {
			compcords = drawImage(compsegments, projectName);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		compcords.addAll(drawLegend());
		return compcords;
	}

	private static List<Component> getDirections(List<Component> comps) {

		int maxWidht = 0;
		int maxHeight = 0;
		comps = sort(comps);
		// System.out.println(segments);
		return comps;
	}

	private static List<ComponentLineSegment> getSegments(Component c, List<ComponentLineSegment> segments, List<Component> comps) {
		// TODO Auto-generated method stub

		if (c.getComponentLevelId() == comps.get(0).getComponentLevelId()) {
			ComponentLineSegment s = new ComponentLineSegment();
			s.setActualLength(c.getComponentLength());
			s.setComponentLength(c.getComponentLength());
			s.setComponentId(c.getComponentId());

			s.setxCoord(100);
			s.setyCoord(350);
			s.setDirection("right");
			s.setComponentName(c.getComponentName());
			s.setScale(800 / (s.getActualLength() * 1000));
			s.setLength(800);
			s.setLevelId(0);
		    System.out.println("c.getProgressString()"+c.getProgressString());
			s.setProgressString(c.getProgressString());
			s.setRemarks(c.getRemarks());
			// s.setProgressString("10-Completed, 20-In Progress, 30-Not
			// Started, 20-Completed, 20-In Progress");
			segments.add(s);
		} else {
			 System.out.println("coming in else");
			ComponentLineSegment s = new ComponentLineSegment();
			s = getParentCanalDetails(s, c, comps, segments);
			segments.add(s);
		}
		return segments;
	}

	private static ComponentLineSegment getParentCanalDetails(ComponentLineSegment s, Component c, List<Component> comps,
			List<ComponentLineSegment> segments) {
		// TODO Auto-generated method stub
		Component parentComponent = null;
		for (Component c1 : comps) {
			if (c1.getComponentId().intValue() == c.getParentComponentId().intValue()) {
				parentComponent = c1;
				break;
			}
		}
		ComponentLineSegment ps = null;
		for (ComponentLineSegment s1 : segments) {
			if (parentComponent.getComponentId().intValue() == s1.getComponentId().intValue()) {
				ps = s1;
				break;
			}
		}
		s.setProgressString(c.getProgressString());
		// s.setProgressString("10-Completed, 20-In Progress, 30-Not Started,
		// 20-Completed, 20-In Progress");
		s.setComponentName(c.getComponentName());
		s.setComponentId(c.getComponentId());
		s.setActualLength(c.getComponentLength());
		s.setComponentLength(c.getComponentLength());
		s.setScale(ps.getScale());
		s.setLevelId(c.getComponentLevelId());
		s.setLength((int) Math.round((s.getActualLength() * 1000 * s.getScale())));
		int addCoord = 0;

		if (ps.getLevelId() == 0)
			addCoord = 40;
		if (ps.getLevelId() == 1)
			addCoord = 25;

		if (ps.getLevelId() == 2)
			addCoord = 20;

		if (ps.getLevelId() == 3)
			addCoord = 15;

		if (ps.getLevelId() == 4)
			addCoord = 10;

		Integer offtake = 0;
		System.out.println("ps.getDirection()"+ps.getDirection());
		if (ps.getDirection().equals("right")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setxCoord(ps.getxCoord() + offtake);
			if (c.getComponentDirection()==2) {
				s.setDirection("down");
				s.setyCoord(ps.getyCoord() + addCoord);

			} else if (c.getComponentDirection()==1) {

				s.setDirection("up");
				s.setyCoord(ps.getyCoord());

			}
		} else if (ps.getDirection().equals("left")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setxCoord(ps.getxCoord() - offtake);
			if (c.getComponentDirection()==2) {
				s.setyCoord(ps.getyCoord());
				s.setDirection("up");

			} else if (c.getComponentDirection()==1) {
				s.setyCoord(ps.getyCoord() + addCoord);

				s.setDirection("down");
			}
		} else if (ps.getDirection().equals("up")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setyCoord(ps.getyCoord() - offtake);
			if (c.getComponentDirection()==2) {
				s.setDirection("right");
				s.setxCoord(ps.getxCoord());
			} else if (c.getComponentDirection()==1) {
				s.setxCoord(ps.getxCoord() + addCoord);
				s.setDirection("left");
			}
		} else if (ps.getDirection().equals("down")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setxCoord(ps.getxCoord());
			s.setyCoord(ps.getyCoord() + offtake);
			if (c.getComponentDirection()==2) {
				s.setxCoord(ps.getxCoord());
				s.setDirection("left");
			} else if (c.getComponentDirection()==1) {
				s.setxCoord(ps.getxCoord() + addCoord);

				s.setDirection("right");
			}
		}
		return s;
	}

	private static List<Component> sort(List<Component> comps) {
		Collections.sort(comps, new Comparator<Component>() {
			public int compare(Component o1, Component o2) {
				if (o1.getComponentLevelId() == o2.getComponentLevelId())
					return (int) (Math.round(o1.getOfftakeChainage() - o2.getOfftakeChainage()));
				return o1.getComponentLevelId() - o2.getComponentLevelId();
			}
		});
		return comps;
	}

	private static List<Component> getAllComponents(Component c, List<Component> compsList, List<Component> comps, Integer level) {
		for (Component com : compsList) {
			if (com.getParentComponentId().intValue() == c.getComponentId().intValue() && !comps.contains(com))
				comps.add(com);
		}
		List<Component> loopComps = new ArrayList<Component>();
		if (level == 0) {
			for (Component com : comps)
				if (com.getComponentLevelId() == 1)
					loopComps.add(com);
			for (Component com : loopComps) {
				comps = getAllComponents(com, compsList, comps, 1);
			}
		} else if (level == 1) {
			for (Component com : comps)
				if (com.getComponentLevelId() == 2)
					loopComps.add(com);
			for (Component com : loopComps) {
				comps = getAllComponents(com, compsList, comps, 2);
			}
		} else if (level == 2) {
			for (Component com : comps)
				if (com.getComponentLevelId() == 3)
					loopComps.add(com);
			for (Component com : loopComps) {
				comps = getAllComponents(com, compsList, comps, 3);
			}
		} else if (level == 3) {
			for (Component com : comps)
				if (com.getComponentLevelId() == 4)
					loopComps.add(com);
			for (Component com : loopComps) {
				comps = getAllComponents(com, compsList, comps, 4);
			}
		}
		return comps;
	}

	private static List<ComponentLineSegment> drawLegend() {
		
		
		List<ComponentLineSegment> segments = new ArrayList<ComponentLineSegment>();

		
		
		
		
		
		
		
	/*	
		segment.setColour("black");
		
		segment.setTextXcord("50");
		segment.setTextYcord("675");
		segment.setCanalName("Legend :: ");
		

		segment = new LineSegment();
*/		/*ComponentLineSegment segment = new ComponentLineSegment();
		segment.setColour("orange");
		segment.setActualLength(15.0);
		segment.setxCoord(53);
		segment.setyCoord(660);
		segment.setComponentWidth(15);

		segment.setTextXcord("70");
		segment.setTextYcord("675");
		segment.setComponentName("- Designs not started");
		segments.add(segment);*/

		/*segment = new ComponentLineSegment();
		segment.setColour("yellow");
		segment.setActualLength(15.0);
		segment.setxCoord(235);
		segment.setyCoord(660);
		segment.setComponentWidth(15);

		segment.setTextXcord("255");
		segment.setTextYcord("675");
		segment.setComponentName("- Designs in progress");
		segments.add(segment);*/

		/*segment = new ComponentLineSegment();
		segment.setColour("pink");
		segment.setActualLength(15.0);
		segment.setxCoord(410);
		segment.setyCoord(660);
		segment.setComponentWidth(15);

		segment.setTextXcord("430");
		segment.setTextYcord("675");
		segment.setComponentName("- Designs Finalized");
		segments.add(segment);*/


	
		
		/*segment = new ComponentLineSegment();
		segment.setColour("brown");
		segment.setActualLength(15.0);
		segment.setxCoord(590);
		segment.setyCoord(660);
		segment.setComponentWidth(15);

		segment.setTextXcord("610");
		segment.setTextYcord("675");
		segment.setComponentName("- Foundation EW");
		segments.add(segment);*/


		/*
		ig2.setColor(Color.black);
		ig2.draw3DRect(680, 660, 15, 15, false);
		ig2.setColor(Color.red);
		ig2.fillRect(680, 660, 15, 15);
		ig2.drawString("--", 700, 675);
		ig2.drawString("Court Cases", 720, 675);
*/
		
		/*segment = new ComponentLineSegment();
		segment.setColour("cyan");
		segment.setActualLength(15.0);
		segment.setxCoord(750);
		segment.setyCoord(660);
		segment.setComponentWidth(15);

		segment.setTextXcord("770");
		segment.setTextYcord("675");
		segment.setComponentName("- Foundation Concrete");
		segments.add(segment);*/

		ComponentLineSegment segment = new ComponentLineSegment();
		
		


		/*
		ig2.setColor(Color.black);
		ig2.draw3DRect(260, 700, 15, 15, true);
		ig2.setColor(Color.orange);
		ig2.fillRect(260, 700, 15, 15);
		ig2.drawString("--", 280, 715);
		ig2.drawString("LA Component", 300, 715);
*/
		
		/*segment = new ComponentLineSegment();
		segment.setColour("purple");
		segment.setActualLength(15.0);
		segment.setxCoord(260);
		segment.setyCoord(700);
		segment.setComponentWidth(15);

		segment.setTextXcord("280");
		segment.setTextYcord("715");
		segment.setComponentName("- Super Structure");
		segments.add(segment);
*/

			
		segment = new ComponentLineSegment();
		segment.setColour("green");
		segment.setActualLength(15.0);
		segment.setxCoord(620);
		segment.setyCoord(700);
		segment.setComponentWidth(15);

		segment.setTextXcord("645");
		segment.setTextYcord("715");
		segment.setComponentName("-Not Commissioned");
		segments.add(segment);
		
		segment = new ComponentLineSegment();
		segment.setColour("yellow");
		segment.setActualLength(15.0);
		segment.setxCoord(380);
		segment.setyCoord(700);
		segment.setComponentWidth(15);

		segment.setTextXcord("405");
		segment.setTextYcord("715");
		segment.setComponentName("- Work In progress");
		segments.add(segment);


		segment = new ComponentLineSegment();
		segment.setColour("red");
		segment.setActualLength(15.0);
		segment.setxCoord(825);
		segment.setyCoord(700);
		segment.setComponentWidth(15);

		segment.setTextXcord("845");
		segment.setTextYcord("715");
		segment.setComponentName("- Not Tackled");
		segments.add(segment);
		
		segment = new ComponentLineSegment();
		segment.setColour("blue");
		segment.setActualLength(15.0);
		segment.setxCoord(225);
		segment.setyCoord(700);
		segment.setComponentWidth(15);

		segment.setTextXcord("250");
		segment.setTextYcord("715");
		segment.setComponentName("- Commissioned");
		segments.add(segment);
		
		return segments;

	}

	private static List<ComponentLineSegment> drawImage(List<ComponentLineSegment> segments, String projectName)
			throws ParseException, IllegalAccessException, InvocationTargetException {
		List<ComponentLineSegment> segmentList = new ArrayList<ComponentLineSegment>();
		for (ComponentLineSegment s : segments) {
			segmentList.addAll(drawLine(s));
		}
		return segmentList;
	}

	private static List<ComponentLineSegment> drawLine(ComponentLineSegment s) throws IllegalAccessException, InvocationTargetException {
		// LineSegment s = new LineSegment();
		
		List<ComponentLineSegment> segments = new ArrayList<ComponentLineSegment>();
		int x = s.getxCoord(), x1 = s.getxCoord(), sx = 0;
		int y = s.getyCoord(), y1 = s.getyCoord(), sy = 0;
		// BeanUtils.copyProperties(segment, s);
		int level = s.getLevelId();
		int rectWidth = 0;
		if (level == 0)
			rectWidth = 40;
		if (level == 1)
			rectWidth = 25;
		if (level == 2)
			rectWidth = 20;
		if (level == 3)
			rectWidth = 15;
		if (level == 4)
			rectWidth = 10;
		if (level == 5)
			rectWidth = 5;
		
		System.out.println("coords classs ==== "+ s.getComponentLength());
		
		int angle = 0, tempx = x, tempy = y, k = s.getLength();
		int length = 0;
		String direction = s.getDirection(), name = s.getComponentName();
		String[] params = {};
		if (null != s.getProgressString()) {
			params = s.getProgressString().split(",");
			
			System.out.println("params"+params);
		}
		

		if (direction.equals("down")) {
			sx = x - 10;
			sy = y - s.getComponentName().length() + k / 4;
			angle = 270;
			ComponentLineSegment segment1 = new ComponentLineSegment();
			BeanUtils.copyProperties(segment1, s);
			segment1.setColour("lightgray");
			segment1.setActualLength(Double.parseDouble(String.valueOf(k)));
			segment1.setxCoord(x);
			segment1.setyCoord(y);
			segment1.setAngle(angle);
			segment1.setComponentWidth(rectWidth);
			segments.add(segment1);
			
			
			if (params.length > 1)

				for (int l = 0; l < params.length; l++) {
					ComponentLineSegment segment = new ComponentLineSegment();
					BeanUtils.copyProperties(segment, s);
					
					String[] values = params[l].split("-");
					
					System.out.println("segment"+values[1]);
					y1 = (y + (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale()))));
					segment.setFlag(true);
					segment.setColour(getColour(Integer.parseInt(values[2].trim())));
					segment.setAngle(angle);
					segment.setRemarks(values[3]);
					segment.setCompLength(Double.parseDouble(values[4].trim()));
					
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
					if (String.valueOf(values[1].trim()).equals("1")) {
						segment.setComponentWidth(5);
						segment.setxCoord(x);
						segment.setyCoord(y1);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						segment.setxCoord(x + 16);
						segment.setyCoord(y1 + 4);
						segment.setX1Coord(x + 20);
						segment.setY1Coord(y1 - 4);
						segment.setX2Coord(x + 24);
						segment.setY2Coord(y1 + 4);
						
					}
					if (String.valueOf(values[1].trim()).equals("3")) {
						
						segment.setxCoord(x + 6);
						segment.setyCoord(y1);
						segment.setX1Coord(x + 6);
						segment.setY1Coord(y1 + 4);
						
					}
					if (String.valueOf(values[1].trim()).equals("4")) {
						segment.setxCoord(x + 20);
						segment.setyCoord(y1);
					}

					segments.add(segment);
				}

			segments.get(0).setAngle(-angle);
			segments.get(0).setTextXcord(String.valueOf(sx));
			segments.get(0).setTextYcord(String.valueOf(sy));
			return segments;
		}
		if (direction.equals("up")) {
			sx = x - 10;
			sy = y - s.getComponentName().length() - k / 2;
			angle = 270;
			length = 0;
			ComponentLineSegment segment1 = new ComponentLineSegment();
			BeanUtils.copyProperties(segment1, s);
			segment1.setColour("cyan");/*lightgray*/
			segment1.setActualLength(Double.parseDouble(String.valueOf(k)));
			segment1.setxCoord(x);
			segment1.setyCoord(y - k);
			segment1.setAngle(angle);
			segment1.setComponentWidth(rectWidth);
			segments.add(segment1);
			//segments.add(segment1);
			
			
			if (params.length > 1)

				for (int l = 0; l < params.length; l++) {
					ComponentLineSegment segment = new ComponentLineSegment();
					BeanUtils.copyProperties(segment, s);
					String[] values = params[l].split("-");
					y1 = y - (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale())));
					segment.setColour(getColour(Integer.parseInt(values[2].trim())));

					segment.setAngle(angle);
					segment.setFlag(true);
					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
					segment.setCompLength(Double.parseDouble(values[4].trim()));

					if (String.valueOf(values[1].trim()).equals("1")) {
						segment.setComponentWidth(5);
						segment.setxCoord(x);
						segment.setyCoord(y1);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						System.out.println("in 2");
						segment.setxCoord(x + 16);
						segment.setyCoord(y1 + 4);
						segment.setX1Coord(x + 20);
						segment.setY1Coord(y1 - 4);
						segment.setX2Coord(x + 24);
						segment.setY2Coord(y1 + 4);
						
					}
					if (String.valueOf(values[1].trim()).equals("3")) {
						
						
						segment.setxCoord(x + 6);
						segment.setyCoord(y1);
						segment.setX1Coord(x + 6);
						segment.setY1Coord(y1 + 4);
					}
					if (String.valueOf(values[1].trim()).equals("4")) {
						segment.setxCoord(x + 20);
						segment.setyCoord(y1);
					}
					segments.add(segment);
				}
		}

		if (direction.equals("right")) {
			length = 0;
			sx = x - s.getComponentName().length() + k / 2;
			sy = y - 3;
			angle = 0;
			ComponentLineSegment segment1 = new ComponentLineSegment();
			BeanUtils.copyProperties(segment1, s);

			segment1.setColour("lightgray");/*lightgray*/
			segment1.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
			segment1.setxCoord(x);
			segment1.setyCoord(y);
			segment1.setAngle(angle);
			segment1.setComponentWidth(k);
			segments.add(segment1);
			
			System.out.println("params.length"+params.length);
			if(params!=null){
			if (params.length >1)

				for (int l = 0; l < params.length; l++) {

					ComponentLineSegment segment = new ComponentLineSegment();
					BeanUtils.copyProperties(segment, s);
					String[] values = params[l].split("-");
					if(values.length>1){
					System.out.println("valueslength"+values.length);
					System.out.println("values0len"+values[0].trim());
					System.out.println("values1len"+values[1].trim());
					System.out.println("values2"+values[2].trim());
					//System.out.println("values3"+values[3].trim());
					x1 = x + (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale())));
					// put x same and increase y
					segment.setColour(getColour(Integer.parseInt(values[2].trim())));
					segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
					segment.setAngle(angle);
					segment.setComponentWidth(length);
					segment.setFlag(true);
					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
					segment.setCompLength(Double.parseDouble(values[4].trim()));
					
					System.out.println("getColour"+segment.getColour());
					System.out.println(segment.getStructureType());
					System.out.println("valofstruct"+String.valueOf(values[1].trim()).equals("3"));
					if (String.valueOf(values[1].trim()).equals("1")) {
						System.out.println("coming here 1");
						segment.setxCoord(x1);
						segment.setyCoord(y);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						System.out.println("coming here 2");
						
						segment.setxCoord(x1);
						segment.setyCoord(y + 10);
						segment.setX1Coord(x1 - 4);
						segment.setY1Coord(y + 15);
						segment.setX2Coord(x1 + 4);
						segment.setY2Coord(y + 15);
						
					}
					
					if (String.valueOf(values[1].trim()).equals("3")) {
						
						System.out.println("coming here 3");
						
						segment.setxCoord(x1);
						segment.setyCoord(y + 5);
						segment.setX1Coord(x1);
						segment.setY1Coord(y + 9);
						
					}
					if (String.valueOf(values[1].trim()).equals("4")) {
						System.out.println("coming here 4");
						segment.setxCoord(x1);
						segment.setyCoord(y + 20);
					}
					}
					segments.add(segment);

				}
			}
			

		}
		System.out.println("before if left");
		if (direction.equals("left")) {
			length = 0;
			// x1 = x - k;
			sx = x - s.getComponentName().length() - 3 * k / 4;
			sy = y - 3;
			angle = 0;
			// System.out.println("x= " + x + "y= " + y + "k= " + k);
			ComponentLineSegment segment1 = new ComponentLineSegment();
			BeanUtils.copyProperties(segment1, s);
			segment1.setColour("blue");/*lightgray*/
			segment1.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
			segment1.setxCoord(tempx - k);
			segment1.setyCoord(y);
			segment1.setAngle(angle);
			segment1.setComponentWidth(k);
			segments.add(segment1);
			System.out.println("also here");
			if (params.length > 1)

				for (int l = 0; l < params.length; l++) {
					ComponentLineSegment segment = new ComponentLineSegment();
					BeanUtils.copyProperties(segment, s);

					String[] values = params[l].split("-");


					x1 = x - (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale())));
					segment.setColour("green");
					segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));

					segment.setAngle(angle);
					segment.setComponentWidth(length);
					segment.setFlag(true);

					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
					segment.setCompLength(Double.parseDouble(values[4].trim()));
					if (String.valueOf(values[1].trim()).equals("1")) {
						segment.setxCoord(x1);
						segment.setyCoord(y);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						
						segment.setxCoord(x1);
						segment.setyCoord(y + 10);
						segment.setX1Coord(x1 - 4);
						segment.setY1Coord(y + 15);
						segment.setX2Coord(x1 + 4);
						segment.setY2Coord(y + 15);
						
					}
					if (String.valueOf(values[1].trim()).equals("3")) {
						
						segment.setxCoord(x1);
						segment.setyCoord(y + 5);
						segment.setX1Coord(x1);
						segment.setY1Coord(y + 9);
						
					}
					if (String.valueOf(values[1].trim()).equals("4")) {
						segment.setxCoord(x1);
						segment.setyCoord(y + 20);
					}

					segments.add(segment);

				}

		}
		
		
		
		// segment.setTextSegment(drawRotate(sx, sy, angle, name));

		segments.get(0).setAngle(-angle);
		segments.get(0).setTextXcord(String.valueOf(sx));
		segments.get(0).setTextYcord(String.valueOf(sy));

		return segments;

	}

	public static String getColour(Integer statusString) {
		
		System.out.println("statusString"+statusString);
		String colour = "";
		switch (statusString) {
		
		case 1:
			colour = "green";
			break;
		case 2:
			colour = "red";
			break;
		case 3:
			colour = "blue";
			break;

		case 13:
			colour = "orange";
			break;

		case 14:
			colour = "yellow";
			break;

		case 15:
			colour = "pink";
			break;

		case 16:
			colour = "brown";
			break;
		case 17:
			colour = "cyan";
			break;

		case 18:
			colour = "blue";
			break;

		case 19:
			colour = "purple";
			break;

		case 20:
			colour = "green";
			break;

		}

		return colour;

	}

}
