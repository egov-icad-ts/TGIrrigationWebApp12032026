package in.ts.icad.project.graphs;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import in.ts.icad.leagal.model.Canal;
import in.ts.icad.leagal.model.LineSegment;

/*This class is used to generate co-ordinates dynamically to build canal line diagram in jsp using svg tags*/
public class CanalStructureCoordinates {

	public static List<LineSegment> getImages(List<Canal> canalsList, String projectName) throws ParseException {

		List<LineSegment> canalcords = new ArrayList<LineSegment>();

		List<Canal> mainCanals = new ArrayList<Canal>();
		for (Canal c : canalsList)
			if (c.getParentId() == canalsList.get(0).getParentId())
				mainCanals.add(c);
			else
				break;

		List<Canal> canals = new ArrayList<Canal>();
		for (Canal c : mainCanals) {
			canals = new ArrayList<Canal>();
			canals.add(c);
			canals = getAllCanals(c, canalsList, canals, canalsList.get(0).getCanalLevelId());
			// System.out.println(canals);
			canals = getDirections(canals);
		}
		List<LineSegment> segments = new ArrayList<LineSegment>();
		for (Canal c : canals) {
			segments = getSegments(c, segments, canals);
		}
		try {
			canalcords = drawImage(segments, projectName);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		canalcords.addAll(drawLegend());
		return canalcords;
	}

	private static List<Canal> getDirections(List<Canal> canals) {

		int maxWidht = 0;
		int maxHeight = 0;
		canals = sort(canals);
		// System.out.println(segments);
		return canals;
	}

	private static List<LineSegment> getSegments(Canal c, List<LineSegment> segments, List<Canal> canals) {
		// TODO Auto-generated method stub

		if (c.getCanalLevelId() == canals.get(0).getCanalLevelId()) {
			LineSegment s = new LineSegment();
			s.setActualLength(c.getCanalLength());
			s.setCanalLength(c.getCanalLength());
			s.setCanalId(c.getCanalId());

			s.setxCoord(100);
			s.setyCoord(350);
			s.setDirection("right");
			s.setCanalName(c.getCanalName());
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
			LineSegment s = new LineSegment();
			s = getParentCanalDetails(s, c, canals, segments);
			segments.add(s);
		}
		return segments;
	}

	private static LineSegment getParentCanalDetails(LineSegment s, Canal c, List<Canal> canals,
			List<LineSegment> segments) {
		// TODO Auto-generated method stub
		Canal parentCanal = null;
		for (Canal c1 : canals) {
			if (c1.getCanalId().intValue() == c.getParentId().intValue()) {
				parentCanal = c1;
				break;
			}
		}
		LineSegment ps = null;
		for (LineSegment s1 : segments) {
			if (parentCanal.getCanalId().intValue() == s1.getCanalId().intValue()) {
				ps = s1;
				break;
			}
		}
		s.setProgressString(c.getProgressString());
		// s.setProgressString("10-Completed, 20-In Progress, 30-Not Started,
		// 20-Completed, 20-In Progress");
		s.setCanalName(c.getCanalName());
		s.setCanalId(c.getCanalId());
		s.setActualLength(c.getCanalLength());
		s.setCanalLength(c.getCanalLength());
		s.setScale(ps.getScale());
		s.setLevelId(c.getCanalLevelId());
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
		if (ps.getDirection().equals("right")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setxCoord(ps.getxCoord() + offtake);
			if (c.getCanalDirection().equals("Right")) {
				s.setDirection("down");
				s.setyCoord(ps.getyCoord() + addCoord);

			} else if (c.getCanalDirection().equals("Left")) {

				s.setDirection("up");
				s.setyCoord(ps.getyCoord());

			}
		} else if (ps.getDirection().equals("left")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setxCoord(ps.getxCoord() - offtake);
			if (c.getCanalDirection().equals("Right")) {
				s.setyCoord(ps.getyCoord());
				s.setDirection("up");

			} else if (c.getCanalDirection().equals("Left")) {
				s.setyCoord(ps.getyCoord() + addCoord);

				s.setDirection("down");
			}
		} else if (ps.getDirection().equals("up")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setyCoord(ps.getyCoord() - offtake);
			if (c.getCanalDirection().equals("Right")) {
				s.setDirection("right");
				s.setxCoord(ps.getxCoord());
			} else if (c.getCanalDirection().equals("Left")) {
				s.setxCoord(ps.getxCoord() + addCoord);
				s.setDirection("left");
			}
		} else if (ps.getDirection().equals("down")) {
			offtake = (Integer) ((Long) (Math.round(c.getOfftakeChainage() * 1000 * s.getScale()))).intValue();
			s.setxCoord(ps.getxCoord());
			s.setyCoord(ps.getyCoord() + offtake);
			if (c.getCanalDirection().equals("Right")) {
				s.setxCoord(ps.getxCoord());
				s.setDirection("left");
			} else if (c.getCanalDirection().equals("Left")) {
				s.setxCoord(ps.getxCoord() + addCoord);

				s.setDirection("right");
			}
		}
		return s;
	}

	private static List<Canal> sort(List<Canal> canals) {
		Collections.sort(canals, new Comparator<Canal>() {
			public int compare(Canal o1, Canal o2) {
				if (o1.getCanalLevelId() == o2.getCanalLevelId())
					return (int) (Math.round(o1.getOfftakeChainage() - o2.getOfftakeChainage()));
				return o1.getCanalLevelId() - o2.getCanalLevelId();
			}
		});
		return canals;
	}

	private static List<Canal> getAllCanals(Canal c, List<Canal> canalsList, List<Canal> canals, Integer level) {
		for (Canal can : canalsList) {
			if (can.getParentId().intValue() == c.getCanalId().intValue() && !canals.contains(can))
				canals.add(can);
		}
		List<Canal> loopCanals = new ArrayList<Canal>();
		if (level == 0) {
			for (Canal can : canals)
				if (can.getCanalLevelId() == 1)
					loopCanals.add(can);
			for (Canal can : loopCanals) {
				canals = getAllCanals(can, canalsList, canals, 1);
			}
		} else if (level == 1) {
			for (Canal can : canals)
				if (can.getCanalLevelId() == 2)
					loopCanals.add(can);
			for (Canal can : loopCanals) {
				canals = getAllCanals(can, canalsList, canals, 2);
			}
		} else if (level == 2) {
			for (Canal can : canals)
				if (can.getCanalLevelId() == 3)
					loopCanals.add(can);
			for (Canal can : loopCanals) {
				canals = getAllCanals(can, canalsList, canals, 3);
			}
		} else if (level == 3) {
			for (Canal can : canals)
				if (can.getCanalLevelId() == 4)
					loopCanals.add(can);
			for (Canal can : loopCanals) {
				canals = getAllCanals(can, canalsList, canals, 4);
			}
		}
		return canals;
	}

	private static List<LineSegment> drawLegend() {
		List<LineSegment> segments = new ArrayList<LineSegment>();

		
		
		
		
		
		
		
	/*	
		segment.setColour("black");
		
		segment.setTextXcord("50");
		segment.setTextYcord("675");
		segment.setCanalName("Legend :: ");
		

		segment = new LineSegment();
*/		LineSegment segment = new LineSegment();
		segment.setColour("orange");
		segment.setActualLength(15.0);
		segment.setxCoord(53);
		segment.setyCoord(660);
		segment.setCanalWidth(15);

		segment.setTextXcord("70");
		segment.setTextYcord("675");
		segment.setCanalName("- Designs not started");
		segments.add(segment);

		segment = new LineSegment();
		segment.setColour("yellow");
		segment.setActualLength(15.0);
		segment.setxCoord(235);
		segment.setyCoord(660);
		segment.setCanalWidth(15);

		segment.setTextXcord("255");
		segment.setTextYcord("675");
		segment.setCanalName("- Designs in progress");
		segments.add(segment);

		segment = new LineSegment();
		segment.setColour("pink");
		segment.setActualLength(15.0);
		segment.setxCoord(410);
		segment.setyCoord(660);
		segment.setCanalWidth(15);

		segment.setTextXcord("430");
		segment.setTextYcord("675");
		segment.setCanalName("- Designs Finalized");
		segments.add(segment);


	
		
		segment = new LineSegment();
		segment.setColour("brown");
		segment.setActualLength(15.0);
		segment.setxCoord(590);
		segment.setyCoord(660);
		segment.setCanalWidth(15);

		segment.setTextXcord("610");
		segment.setTextYcord("675");
		segment.setCanalName("- Foundation EW");
		segments.add(segment);


		/*
		ig2.setColor(Color.black);
		ig2.draw3DRect(680, 660, 15, 15, false);
		ig2.setColor(Color.red);
		ig2.fillRect(680, 660, 15, 15);
		ig2.drawString("--", 700, 675);
		ig2.drawString("Court Cases", 720, 675);
*/
		
		segment = new LineSegment();
		segment.setColour("cyan");
		segment.setActualLength(15.0);
		segment.setxCoord(750);
		segment.setyCoord(660);
		segment.setCanalWidth(15);

		segment.setTextXcord("770");
		segment.setTextYcord("675");
		segment.setCanalName("- Foundation Concrete");
		segments.add(segment);


		
		segment = new LineSegment();
		segment.setColour("blue");
		segment.setActualLength(15.0);
		segment.setxCoord(55);
		segment.setyCoord(700);
		segment.setCanalWidth(15);

		segment.setTextXcord("80");
		segment.setTextYcord("715");
		segment.setCanalName("- Sub Structure");
		segments.add(segment);


		/*
		ig2.setColor(Color.black);
		ig2.draw3DRect(260, 700, 15, 15, true);
		ig2.setColor(Color.orange);
		ig2.fillRect(260, 700, 15, 15);
		ig2.drawString("--", 280, 715);
		ig2.drawString("LA Component", 300, 715);
*/
		
		segment = new LineSegment();
		segment.setColour("purple");
		segment.setActualLength(15.0);
		segment.setxCoord(260);
		segment.setyCoord(700);
		segment.setCanalWidth(15);

		segment.setTextXcord("280");
		segment.setTextYcord("715");
		segment.setCanalName("- Super Structure");
		segments.add(segment);


			
		segment = new LineSegment();
		segment.setColour("green");
		segment.setActualLength(15.0);
		segment.setxCoord(440);
		segment.setyCoord(700);
		segment.setCanalWidth(15);

		segment.setTextXcord("465");
		segment.setTextYcord("715");
		segment.setCanalName("- Work Completed");
		segments.add(segment);


		segment = new LineSegment();
		segment.setColour("red");
		segment.setActualLength(15.0);
		segment.setxCoord(625);
		segment.setyCoord(700);
		segment.setCanalWidth(15);

		segment.setTextXcord("645");
		segment.setTextYcord("715");
		segment.setCanalName("- Not Started");
		segments.add(segment);
		return segments;

	}

	private static List<LineSegment> drawImage(List<LineSegment> segments, String projectName)
			throws ParseException, IllegalAccessException, InvocationTargetException {
		List<LineSegment> segmentList = new ArrayList<LineSegment>();
		for (LineSegment s : segments) {
			segmentList.addAll(drawLine(s));
		}
		return segmentList;
	}

	private static List<LineSegment> drawLine(LineSegment s) throws IllegalAccessException, InvocationTargetException {
		// LineSegment s = new LineSegment();
		
		List<LineSegment> segments = new ArrayList<LineSegment>();
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
		
		System.out.println("coords classs ==== "+ s.getCanalLength());
		
		int angle = 0, tempx = x, tempy = y, k = s.getLength();
		int length = 0;
		String direction = s.getDirection(), name = s.getCanalName();
		String[] params = {};
		if (null != s.getProgressString()) {
			params = s.getProgressString().split(",");
			
			System.out.println("params"+params);
		}
		

		if (direction.equals("down")) {
			sx = x - 10;
			sy = y - s.getCanalName().length() + k / 4;
			angle = 270;
			LineSegment segment1 = new LineSegment();
			BeanUtils.copyProperties(segment1, s);
			segment1.setColour("lightgray");
			segment1.setActualLength(Double.parseDouble(String.valueOf(k)));
			segment1.setxCoord(x);
			segment1.setyCoord(y);
			segment1.setAngle(angle);
			segment1.setCanalWidth(rectWidth);
			segments.add(segment1);
			
			
			if (params.length > 1)

				for (int l = 0; l < params.length; l++) {
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					
					String[] values = params[l].split("-");
					
					System.out.println("segment"+values[1]);
					y1 = (y + (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale()))));
					segment.setFlag(true);
					segment.setColour(getColour(Integer.parseInt(values[2].trim())));
					segment.setAngle(angle);
					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
					if (String.valueOf(values[1].trim()).equals("1")) {
						segment.setCanalWidth(5);
						segment.setxCoord(x);
						segment.setyCoord(y1);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						segment.setxCoord(x + 6);
						segment.setyCoord(y1);
						segment.setX1Coord(x + 6);
						segment.setY1Coord(y1 + 4);
					}
					if (String.valueOf(values[1].trim()).equals("3")) {
						segment.setxCoord(x + 16);
						segment.setyCoord(y1 + 4);
						segment.setX1Coord(x + 20);
						segment.setY1Coord(y1 - 4);
						segment.setX2Coord(x + 24);
						segment.setY2Coord(y1 + 4);
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
			sy = y - s.getCanalName().length() - k / 2;
			angle = 270;
			length = 0;
			LineSegment segment1 = new LineSegment();
			BeanUtils.copyProperties(segment1, s);
			segment1.setColour("cyan");/*lightgray*/
			segment1.setActualLength(Double.parseDouble(String.valueOf(k)));
			segment1.setxCoord(x);
			segment1.setyCoord(y - k);
			segment1.setAngle(angle);
			segment1.setCanalWidth(rectWidth);
			segments.add(segment1);
			segments.add(segment1);
			
			
			if (params.length > 1)

				for (int l = 0; l < params.length; l++) {
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					String[] values = params[l].split("-");
					y1 = y - (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale())));
					segment.setColour(getColour(Integer.parseInt(values[2].trim())));

					segment.setAngle(angle);
					segment.setFlag(true);
					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);

					if (String.valueOf(values[1].trim()).equals("1")) {
						segment.setCanalWidth(5);
						segment.setxCoord(x);
						segment.setyCoord(y1);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						segment.setxCoord(x + 6);
						segment.setyCoord(y1);
						segment.setX1Coord(x + 6);
						segment.setY1Coord(y1 + 4);
					}
					if (String.valueOf(values[1].trim()).equals("3")) {
						segment.setxCoord(x + 16);
						segment.setyCoord(y1 + 4);
						segment.setX1Coord(x + 20);
						segment.setY1Coord(y1 - 4);
						segment.setX2Coord(x + 24);
						segment.setY2Coord(y1 + 4);
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
			sx = x - s.getCanalName().length() + k / 2;
			sy = y - 3;
			angle = 0;
			LineSegment segment1 = new LineSegment();
			BeanUtils.copyProperties(segment1, s);

			segment1.setColour("lightgray");/*lightgray*/
			segment1.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
			segment1.setxCoord(x);
			segment1.setyCoord(y);
			segment1.setAngle(angle);
			segment1.setCanalWidth(k);
			segments.add(segment1);
			
			System.out.println("params.length"+params.length);
			if(params!=null){
			if (params.length >=1)

				for (int l = 0; l < params.length; l++) {

					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					String[] values = params[l].split("-");
					if(values.length>1){
					System.out.println("valueslength"+values.length);
					System.out.println("values0len"+values[0].trim());
					System.out.println("values1len"+values[1].trim());
					System.out.println("values2"+values[2].trim());
					System.out.println("values3"+values[3].trim());
					x1 = x + (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale())));
					// put x same and increase y
					segment.setColour(getColour(Integer.parseInt(values[2].trim())));
					segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
					segment.setAngle(angle);
					segment.setCanalWidth(length);
					segment.setFlag(true);
					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
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
						segment.setyCoord(y + 5);
						segment.setX1Coord(x1);
						segment.setY1Coord(y + 9);
					}
					
					if (String.valueOf(values[1].trim()).equals("3")) {
						
						System.out.println("coming here 3");
						segment.setxCoord(x1);
						segment.setyCoord(y + 10);
						segment.setX1Coord(x1 - 4);
						segment.setY1Coord(y + 15);
						segment.setX2Coord(x1 + 4);
						segment.setY2Coord(y + 15);
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
			sx = x - s.getCanalName().length() - 3 * k / 4;
			sy = y - 3;
			angle = 0;
			// System.out.println("x= " + x + "y= " + y + "k= " + k);
			LineSegment segment1 = new LineSegment();
			BeanUtils.copyProperties(segment1, s);
			segment1.setColour("blue");/*lightgray*/
			segment1.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
			segment1.setxCoord(tempx - k);
			segment1.setyCoord(y);
			segment1.setAngle(angle);
			segment1.setCanalWidth(k);
			segments.add(segment1);
			System.out.println("also here");
			if (params.length > 1)

				for (int l = 0; l < params.length; l++) {
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);

					String[] values = params[l].split("-");


					x1 = x - (int) (Math.round((Double.parseDouble(String.valueOf(values[0].trim())) * 1000 * s.getScale())));
					segment.setColour("green");
					segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));

					segment.setAngle(angle);
					segment.setCanalWidth(length);
					segment.setFlag(true);

					segment.setRemarks(values[3]);
					segment.setChainageAt(Double.parseDouble(String.valueOf(values[0])));
					segment.setStructureType(values[1]);
					if (String.valueOf(values[1].trim()).equals("1")) {
						segment.setxCoord(x1);
						segment.setyCoord(y);
					}
					if (String.valueOf(values[1].trim()).equals("2")) {
						segment.setxCoord(x1);
						segment.setyCoord(y + 5);
						segment.setX1Coord(x1);
						segment.setY1Coord(y + 9);
					}
					if (String.valueOf(values[1].trim()).equals("3")) {
						segment.setxCoord(x1);
						segment.setyCoord(y + 10);
						segment.setX1Coord(x1 - 4);
						segment.setY1Coord(y + 15);
						segment.setX2Coord(x1 + 4);
						segment.setY2Coord(y + 15);
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
		String colour = "";
		switch (statusString) {

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
