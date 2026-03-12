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
public class CanalCoordinates {
	static int compId = 0;

	public static List<LineSegment> getImages(List<Canal> canalsList, String projectName) throws ParseException {
		compId = canalsList.get(0).getComponent().getComponentId();

		List<LineSegment> canalcords = new ArrayList<LineSegment>();

		List<Canal> mainCanals = new ArrayList<Canal>();
		for (Canal c : canalsList){
			System.out.println("inside for "+c);
			if (c.getParentId() == canalsList.get(0).getParentId())
				mainCanals.add(c);
			else
				break;
		}
		
		List<Canal> canals = new ArrayList<Canal>();
		for (Canal c : mainCanals) {
			canals = new ArrayList<Canal>();
			canals.add(c);
			canals = getAllCanals(c, canalsList, canals,canalsList.get(0).getCanalLevelId());
			 System.out.println("canals get direction == "+canals);
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
			s.setProgressString(c.getProgressString());
			s.setRemarks(c.getRemarks());
			// s.setProgressString("10-Completed, 20-In Progress, 30-Not
			// Started, 20-Completed, 20-In Progress");
			segments.add(s);
		} else {
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
		System.out.println("inside ccords = "+c);

		for (Canal can : canalsList) {
			System.out.println("inside ccords = "+can);
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

		if (compId != 1) {
			/*ig2.setColor(Color.black);
			// ig2.draw3DRect(650, 450, 225, 175, true);
			ig2.drawString("Legend::", 150, 675);
			ig2.draw3DRect(250, 660, 15, 15, false);
			ig2.setColor(Color.RED);
			ig2.fillRect(250, 660, 15, 15);
			ig2.drawString("----", 275, 675);
			ig2.drawString("Not Started", 315, 675);
			
			*/
			
			LineSegment segment = new LineSegment();
			segment.setColour("black");
			
			segment.setTextXcord("150");
			segment.setTextYcord("100");
			segment.setCanalName("Legend :: ");
			
            segment = new LineSegment();
			segment.setColour("red");
			segment.setActualLength(15.0);
			segment.setxCoord(250);
			segment.setyCoord(85);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("275");
			segment.setTextYcord("100");
			segment.setCanalName("---  Not Started");
			
			segments.add(segment);
			

			/*ig2.setColor(Color.black);
			ig2.draw3DRect(425, 660, 15, 15, false);
			ig2.setColor(Color.blue);
			ig2.fillRect(425, 660, 15, 15);
			ig2.drawString("-----", 465, 675);
			ig2.drawString("In Progress", 515, 675);
*/
			
			
			segment = new LineSegment();
			segment.setColour("blue");
			segment.setActualLength(15.0);
			segment.setxCoord(425);
			segment.setyCoord(85);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("445");
			segment.setTextYcord("100");
			segment.setCanalName("--- In Progress");
			
			segments.add(segment);
			
			/*ig2.setColor(Color.black);
			ig2.draw3DRect(625, 660, 15, 15, true);
			ig2.setColor(Color.green);
			ig2.fillRect(625, 660, 15, 15);
			ig2.drawString("-----", 665, 675);
			ig2.drawString("Completed", 705, 675);
*/
			
			
			segment = new LineSegment();
			segment.setColour("green");
			segment.setActualLength(15.0);
			segment.setxCoord(625);
			segment.setyCoord(85);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("645");
			segment.setTextYcord("100");
			segment.setCanalName("--- Completed");
			segments.add(segment);
			/*ig2.setColor(Color.black);
			ig2.draw3DRect(815, 660, 15, 15, true);
			ig2.setColor(Color.black);
			ig2.fillRect(815, 660, 15, 15);
			ig2.drawString("-----", 855, 675);
			ig2.drawString("Not Updated", 895, 675);
*/
			
			segment = new LineSegment();
			segment.setColour("black");
			segment.setActualLength(15.0);
			segment.setxCoord(815);
			segment.setyCoord(85);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("835");
			segment.setTextYcord("100");
			segment.setCanalName("--- Not Updated");
			segments.add(segment);

		} else {
			/*ig2.setColor(Color.black);
			ig2.drawString("Legend::", 40, 675);
			
			*/
			
			LineSegment segment = new LineSegment();
			segment.setColour("black");
			
			segment.setTextXcord("50");
			segment.setTextYcord("675");
			segment.setCanalName("Legend :: ");
			

			/*ig2.draw3DRect(120, 660, 15, 15, false);
			ig2.setColor(Color.cyan);
			ig2.fillRect(120, 660, 15, 15);
			ig2.drawString("--", 140, 675);
			ig2.drawString("In Survey", 160, 675);
			*/
			segment = new LineSegment();
			segment.setColour("cyan");
			segment.setActualLength(15.0);
			segment.setxCoord(120);
			segment.setyCoord(660);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("140");
			segment.setTextYcord("675");
			segment.setCanalName("-- In Survey");
			segments.add(segment);

			
			
			
			/*ig2.setColor(Color.black);
			ig2.draw3DRect(260, 660, 15, 15, false);
			ig2.setColor(Color.blue);
			ig2.fillRect(260, 660, 15, 15);
			ig2.drawString("--", 280, 675);
			ig2.drawString("DN issued", 300, 675);
			*/
			segment = new LineSegment();
			segment.setColour("blue");
			segment.setActualLength(15.0);
			segment.setxCoord(260);
			segment.setyCoord(660);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("280");
			segment.setTextYcord("675");
			segment.setCanalName("-- DN Issued");
			segments.add(segment);

			/*ig2.setColor(Color.black);
			ig2.draw3DRect(400, 660, 15, 15, false);
			ig2.setColor(Color.YELLOW);
			ig2.fillRect(400, 660, 15, 15);
			ig2.drawString("--", 420, 675);
			ig2.drawString("DD issued", 420, 675);*/
			
			segment = new LineSegment();
			segment.setColour("yellow");
			segment.setActualLength(15.0);
			segment.setxCoord(400);
			segment.setyCoord(660);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("420");
			segment.setTextYcord("675");
			segment.setCanalName("-- DD Issued");
			segments.add(segment);


			/*ig2.setColor(Color.black);
			ig2.draw3DRect(520, 660, 15, 15, true);
			ig2.setColor(Color.green);
			ig2.fillRect(520, 660, 15, 15);
			ig2.drawString("--", 540, 675);
			ig2.drawString("Land Aquired", 560, 675);
*/
			
			segment = new LineSegment();
			segment.setColour("green");
			segment.setActualLength(15.0);
			segment.setxCoord(520);
			segment.setyCoord(660);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("540");
			segment.setTextYcord("675");
			segment.setCanalName("-- Land Aquired");
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
			segment.setColour("brown");
			segment.setActualLength(15.0);
			segment.setxCoord(680);
			segment.setyCoord(660);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("700");
			segment.setTextYcord("675");
			segment.setCanalName("-- Court Cases");
			segments.add(segment);


			/*
			ig2.setColor(Color.black);
			ig2.draw3DRect(120, 700, 15, 15, false);
			ig2.setColor(Color.gray);
			ig2.fillRect(120, 700, 15, 15);
			ig2.drawString("--", 140, 715);
			ig2.drawString("LA Heldup", 160, 715);
*/
			
			segment = new LineSegment();
			segment.setColour("gray");
			segment.setActualLength(15.0);
			segment.setxCoord(120);
			segment.setyCoord(700);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("140");
			segment.setTextYcord("715");
			segment.setCanalName("-- LA Heldup");
			segments.add(segment);


			/*
			ig2.setColor(Color.black);
			ig2.draw3DRect(260, 700, 15, 15, true);
			ig2.setColor(Color.orange);
			ig2.fillRect(260, 700, 15, 15);
			ig2.drawString("--", 280, 715);
			ig2.drawString("LA Component", 300, 715);
*/
			/*
			segment = new LineSegment();
			segment.setColour("orange");
			segment.setActualLength(15.0);
			segment.setxCoord(260);
			segment.setyCoord(700);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("280");
			segment.setTextYcord("715");
			segment.setCanalName("-- LA Component");
			segments.add(segment);*/


			/*
			ig2.setColor(Color.black);
			ig2.draw3DRect(440, 700, 15, 15, false);
			ig2.setColor(Color.pink);
			ig2.fillRect(440, 700, 15, 15);
			ig2.drawString("--", 465, 715);
			ig2.drawString("Forest clearence", 485, 715);
*/
			
			segment = new LineSegment();
			segment.setColour("pink");
			segment.setActualLength(15.0);
			segment.setxCoord(440);
			segment.setyCoord(700);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("465");
			segment.setTextYcord("715");
			segment.setCanalName("-- Forest clearence");
			segments.add(segment);


			/*
			ig2.setColor(Color.black);
			ig2.draw3DRect(625, 700, 15, 15, true);
			ig2.setColor(Color.black);
			ig2.fillRect(625, 700, 15, 15);
			ig2.drawString("--", 645, 715);
			ig2.drawString("Not Updated", 665, 715);
*/

			
			segment = new LineSegment();
			segment.setColour("black");
			segment.setActualLength(15.0);
			segment.setxCoord(625);
			segment.setyCoord(700);
			segment.setCanalWidth(15);
	
			segment.setTextXcord("645");
			segment.setTextYcord("715");
			segment.setCanalName("-- Not Updated");
			segments.add(segment);


			
		}
		
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

		int angle = 0, tempx = x, tempy = y, k = s.getLength();
		int length = 0;

		String direction = s.getDirection(), name = s.getCanalName();
		
		System.out.println("pg string        "+s.getProgressString());
		String[] params = {};
		if(null!=s.getProgressString()){
			params= s.getProgressString().split(",");
		}
		 
		if (direction.equals("down")) {
			sx = x-10;
			sy = y -s.getCanalName().length()+ k / 4;
			angle = 270;
			if (params.length > 0)

				for (int l = 0; l < params.length; l++) {
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					String[] values = params[l].split("-");
					
					y1 = y1 + (k * Integer.parseInt(values[0].trim()) / 100);
					length = (k * Integer.parseInt(values[0].trim()) / 100);
	
					
					if (values[1].equals("Completed")) {
						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);

					}
					if (values[1].equals("In Progress")) {
						segment.setColour("blue");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);						
					}
					if (values[1].equals("Not Started")) {
						segment.setColour("red");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);
					}
					/* added by anusha */

					if (values[1].equals("Survey in progress")) {
						segment.setColour("cyan");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);
					}
					if (values[1].equals("DN issued")) {

						segment.setColour("BLUE");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("DD issued")) {
						segment.setColour("YELLOW");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}

					if (values[1].equals("Land Aquired")) {
						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("LA Heldup")) {
						segment.setColour("gray");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("LA Court Cases")) {
						segment.setColour("brown");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("LA Component")) {
						segment.setColour("orange");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}

					if (values[1].equals("Forest clearence")) {
						segment.setColour("pink");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}

					if (values[1].equals("Not Updated")) {
						segment.setColour("black");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					segments.add(segment);
					tempy = y1;
				}
			else {
				LineSegment segment = new LineSegment();
				BeanUtils.copyProperties(segment, s);
				
				segment.setColour("black");
				segment.setActualLength(Double.parseDouble(String.valueOf(k)));
				segment.setxCoord(x);
				segment.setyCoord(y);
				segment.setAngle(angle);
				segment.setCanalWidth(rectWidth);
				segments.add(segment);

			}

			segments.get(0).setAngle(-angle);
			segments.get(0).setTextXcord(String.valueOf(sx));
			segments.get(0).setTextYcord(String.valueOf(sy));

			return segments;
		}
		if (direction.equals("up")) {
			sx = x-10;
			sy = y -s.getCanalName().length()- k / 2;
			angle = 270;
			length = 0;

			if (params.length > 0)
				for (int l = 0; l < params.length; l++) {
					
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					
					String[] values = params[l].split("-");

					y1 = y1 - (k * Integer.parseInt(values[0].trim()) / 100);
					length = (k * Integer.parseInt(values[0].trim()) / 100);
					
					

					if (values[1].equals("Completed")) {

						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);

						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("In Progress")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("blue");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("Not Started")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);segment.setColour("cyan");
						segment.setColour("red");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}

					/* added by anusha */
					if (values[1].equals("Survey in progress")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("cyan");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("DN issued")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("BLUE");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("DD issued")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("YELLOW");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}

					if (values[1].equals("Land Aquired")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("LA Heldup")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("gray");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("LA Court Cases")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("brown");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("LA Component")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("orange");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}

					if (values[1].equals("Forest clearence")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("pink");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}

					if (values[1].equals("Not Updated")) {
						// ig2.fill3DRect(x, (tempy - length), rectWidth,
						// length, true);
						segment.setColour("black");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(x);
						segment.setyCoord(tempy - length);
						segment.setAngle(angle);
						segment.setCanalWidth(rectWidth);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					tempy = y1;
					segments.add(segment);

				}
			else {
				// ig2.draw(new Line2D.Double(x, y, x, y - k));
				// ig2.fill3DRect(x, y - k, rectWidth, k, true);
				LineSegment segment = new LineSegment();
				BeanUtils.copyProperties(segment, s);
				
				segment.setColour("black");
				segment.setActualLength(Double.parseDouble(String.valueOf(k)));
				segment.setxCoord(x);
				segment.setyCoord(y - k);
				segment.setAngle(angle);
				segment.setCanalWidth(rectWidth);
				segments.add(segment);
				segments.add(segment);
				

			}

		}
		if (direction.equals("right")) {
			length = 0;
			sx = x-s.getCanalName().length() + k / 2;
			sy = y-3;
			angle = 0;

			if (params.length > 0)
				for (int l = 0; l < params.length; l++) {
					
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					
					String[] values = params[l].split("-");
					x1 = x1 + (k * Integer.parseInt(values[0].trim()) / 100);
					length = (k * Integer.parseInt(values[0].trim()) / 100);
					
					

					if (values[1].equals("Completed")) {
						/*
						 * ig2.setColor(Color.green); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, false);
						 */

						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("In Progress")) {
						/*
						 * ig2.setColor(Color.BLUE); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * 
						 * ig2.fill3DRect(tempx, y, length, rectWidth, false);
						 */

						segment.setColour("BLUE");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("Not Started")) {
						/*
						 * ig2.setColor(Color.RED); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, false);
						 */
						segment.setColour("red");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					/* added by anusha */
					if (values[1].equals("Survey in progress")) {
						/*
						 * ig2.setColor(Color.cyan); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */
						segment.setColour("cyan");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("DN issued")) {
						/*
						 * ig2.setColor(Color.BLUE); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */
						segment.setColour("BLUE");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("DD issued")) {
						/*
						 * ig2.setColor(Color.YELLOW); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */
						segment.setColour("YELLOW");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}

					if (values[1].equals("Land Aquired")) {
						/*
						 * ig2.setColor(Color.green); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */

						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("LA Heldup")) {
						// ig2.setColor(Color.gray);
						// // ig2.draw(new Line2D.Double(tempx, y, x1, y));
						// ig2.fill3DRect(tempx, y, length, rectWidth, true);

						segment.setColour("gray");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("LA Court Cases")) {
						/*
						 * ig2.setColor(Color.RED); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */
						segment.setColour("brown");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("LA Component")) {
						/*
						 * ig2.setColor(Color.ORANGE); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */

						segment.setColour("orange");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}

					if (values[1].equals("Forest clearence")) {
						/*
						 * ig2.setColor(Color.pink); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */

						segment.setColour("pink");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);

					}

					if (values[1].equals("Not Updated")) {
						/*
						 * ig2.setColor(Color.black); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * ig2.fill3DRect(tempx, y, length, rectWidth, true);
						 */
						segment.setColour("black");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					segments.add(segment);
					System.out.println(segment);

					tempx = x1;
				}
			else {
				// ig2.draw(new Line2D.Double(x, y, x + k, y));
				// ig2.fill3DRect(x, y, k, rectWidth, true);
				LineSegment segment = new LineSegment();
				BeanUtils.copyProperties(segment, s);

				segment.setColour("black");
				segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
				segment.setxCoord(x);
				segment.setyCoord(y);
				segment.setAngle(angle);
				segment.setCanalWidth(k);
				segments.add(segment);

			}

		}
		if (direction.equals("left")) {
			length = 0;
			// x1 = x - k;
			sx = x-s.getCanalName().length() - 3*k / 4;
			sy = y-3;
			angle = 0;

			if (params.length > 0)
				for (int l = 0; l < params.length; l++) {
					LineSegment segment = new LineSegment();
					BeanUtils.copyProperties(segment, s);
					

					String[] values = params[l].split("-");


					x1 = x1 - (k * Integer.parseInt(values[0].trim()) / 100);
					length = k * Integer.parseInt(values[0].trim()) / 100;
					
					
					

					if (values[1].equals("Completed")) {
						/*
						 * ig2.setColor(Color.green); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */

						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);



					}
					if (values[1].equals("In Progress")) {
						/*
						 * ig2.setColor(Color.BLUE); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */

						segment.setColour("BLUE");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("Not Started")) {
						/*
						 * ig2.setColor(Color.RED); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * 
						 * ig2.fill3DRect(tempx - length, y, length, rectWidth,
						 * true);
						 */
						segment.setColour("red");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					/* added by anusha */
					if (values[1].equals("Survey in progress")) {
						/*
						 * ig2.setColor(Color.cyan); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * 
						 * ig2.fill3DRect(tempx - length, y, length, rectWidth,
						 * true);
						 */

						segment.setColour("cyan");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("DN issued")) {
						/*
						 * ig2.setColor(Color.BLUE); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y));
						 * 
						 * ig2.fill3DRect(tempx - length, y, length, rectWidth,
						 * true);
						 */

						segment.setColour("blue");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("DD issued")) {
						/*
						 * ig2.setColor(Color.YELLOW); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */

						segment.setColour("yellow");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("Land Aquired")) {
						/*
						 * ig2.setColor(Color.green); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */

						segment.setColour("green");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("LA Heldup")) {
						/*
						 * ig2.setColor(Color.gray); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */

						segment.setColour("gray");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("LA Court Cases")) {
						/*
						 * ig2.setColor(Color.RED); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */

						segment.setColour("brown");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("LA Component")) {
						/*
						 * ig2.setColor(Color.ORANGE); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */
						segment.setColour("orange");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(tempx - rectWidth);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}
					if (values[1].equals("Forest clearence")) {
						/*
						 * ig2.setColor(Color.pink); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */
						segment.setColour("pink");
						segment.setActualLength(Double.parseDouble(String.valueOf(length)));
						segment.setxCoord(tempx - rectWidth);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}

					if (values[1].equals("Not Updated")) {
						/*
						 * ig2.setColor(Color.black); // ig2.draw(new
						 * Line2D.Double(tempx, y, x1, y)); ig2.fill3DRect(tempx
						 * - length, y, length, rectWidth, true);
						 */segment.setColour("black");
						segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
						segment.setxCoord(tempx - length);
						segment.setyCoord(y);
						segment.setAngle(angle);
						segment.setCanalWidth(length);
						segment.setRemarks(values[2]);
						segment.setFromKm(values[3]);
						segment.setToKm(values[4]);
						segment.setPercentageComplete(values[0]);


					}

					tempx = x1;
					
					segments.add(segment);

					
				}
			else {
				
				LineSegment segment = new LineSegment();
				BeanUtils.copyProperties(segment, s);
				segment.setColour("black");
				segment.setActualLength(Double.parseDouble(String.valueOf(rectWidth)));
				segment.setxCoord(tempx - k);
				segment.setyCoord(y);
				segment.setAngle(angle);
				segment.setCanalWidth(k);

				segments.add(segment);
			}

		}
		//segment.setTextSegment(drawRotate(sx, sy, angle, name));
		
		segments.get(0).setAngle(-angle);
		segments.get(0).setTextXcord(String.valueOf(sx));
		segments.get(0).setTextYcord(String.valueOf(sy));

		return segments;

	}

	
}
