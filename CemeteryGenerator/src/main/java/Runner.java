import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Runner {
	
	/*	 <tr>
		 <td>שמואל מזרחי</td>
		 <td><img class="mat" style="width:400px;"
		 src="//static.wixstatic.com/media/d7f977_46ed741889864f2cac376fdc82140c85.jpg" /></td> <td><img class="mat" style="width: 159px;"
		 src="https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg" /></td>
		 <td><a href="mailto:erez_oren@yahoo.com?subject= אודות  שמואל מזרחי">
		 שלחו לנו מידע נוסף על שמואל מזרחי </a></td>
		 </tr>
		 */
	
	public static void main(String[] args) throws IOException {
		
		List<SingleRecord> hal = createList();
		int i = 0;
		for (SingleRecord singleRecord : hal) {
			i++;
			
			// System.err.println(createTableRowV1(singleRecord));
			System.err.println(createTableRowV2(singleRecord, i));
			
		}
		System.err.println("Generated " + i + " records");
		
	}
	
	private static String createTableRowV1(SingleRecord singleRecord) throws MalformedURLException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>");
		sb.append(System.getProperty("line.separator"));
		sb.append("<td>" + singleRecord.getFullName() + "</td>");
		sb.append(System.getProperty("line.separator"));
		sb.append("<td style=\"vertical-align: top;\"><img class=\"mat\" style=\"width:400px;\"");
		sb.append(System.getProperty("line.separator"));
		sb.append(" src=\"" + singleRecord.getTumbImage() + "\" /></td> <td style=\"vertical-align: top;\"><img  style=\"width: 200px;\"");
		sb.append(System.getProperty("line.separator"));
		sb.append("src=\"" + singleRecord.getFaceImage() + "\" /></td>");
		sb.append(System.getProperty("line.separator"));
		// sb.append("<td><a href=\"mailto:erez_oren@yahoo.com?subject=" + new String("אודות ").concat(singleRecord.getFullName()) + "\">");
		// sb.append(System.getProperty("line.separator"));
		// sb.append("שלחו לנו מידע נוסף על " + singleRecord.getFullName() + " </a></td>");
		sb.append("<td>" + getDescription(singleRecord.getId()) + "</td>");
		sb.append(System.getProperty("line.separator"));
		sb.append("</tr>");
		return sb.toString();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * <tr>
				<td><a href="#myPopup"
					data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all">אהרן-דב פיגנבלט <img style="width: 200px;"
					src="http://www.izkor.mod.gov.il/Data/korot/Image/091678.jpg" /></a>
				<div data-role="popup" id="myPopup" class="ui-content">
				    <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
							<p class="innerText">
								בן פרומה ושלמה, נולד ביום כ&quot;ב בשבט תרפ&quot;ח <span
									style="white-space: nowrap;">(13.2.1928)</span> בעפולה. בהיותו
								בן שמונה עברו הוריו לגור בקרית מוצקין שליד חיפה ושם למד בבית-ספר
								יסודי. הוא התמסר לפעילות בתנועות נוער, תחילה ב&quot;מכבי&quot;
								ואחר-כך בתנועת &quot;המחנות העולים&quot;, שם שימש כמדריך, יצא
								להכשרה במשק יגור, והצטרף לשורות הפלמ&quot;ח. בכל הפעולות שהשתתף
								בהן גילה רוח נכונות והקרבה, אם בהורדת מעפילים ואם בשדות-קרב.
							</p>
							<p class="innerText">בפרוץ מלחמת-העצמאות נתמנה למפקד מחלקה
								ובראש מחלקתו נשלח להרי ירושלים ובמסגרת חטיבת &quot;הראל&quot;
								השתתף בפעולות רבות בהרים ובכפרי הערבים.</p>
							<p class="innerText">
								אהרן-דב נפל אור ליום י&quot;ד בניסן תש&quot;ח <span
									style="white-space: nowrap;">(23.4.1948)</span> בקרב נבי-סמואל.
								לקראת סוף אפריל <span dir="ltr">1948</span> נערך בגזרת ירושלים
								מבצע &quot;יבוסי&quot;, שנועד ליצור רצף טריטוריאלי עברי בתוך העיר
								ובין ירושלים לבין היישובים שבצפונה. לצורך המבצע הועברה חטיבת
								&quot;הראל&quot; לירושלים ובליל <span dir="ltr">22</span>-<span
									dir="ltr">23</span> באפריל <span dir="ltr">1948</span> יצאו
								כוחותיה לתקוף את שועפת, בית-איכסא ונבי-סמואל. תנועת הכוח
								לנבי-סמואל ארכה זמן רב וההסתערות החלה עם שחר. נוכח אש האויב נאלץ
								הכוח לסגת ובנסיגה הקשה לאור היום היו נפגעים רבים. אהרן-דב ידע כי
								פעולה זו קשה מאוד ולפני צאתו אמר זאת לחברו, ואף-על-פי-כן לא נרתע
								עד הרגע האחרון. הוא היה מפקד המחלקה שתקפה ועם נסיגתה נשאר לחפות
								עליה. כדור פגע בבטנו והוא דרש במפגיע מחבריו שיניחוהו לנפשו כדי
								שלא לעכבם בנסיגתם. כנראה שם בעצמו קץ לחייו ברימון כדי שלא יפול
								בידי האויב, כי גופתו הובאה לבסיס כשהיא מרוסקת מרימון. הובא
								למנוחת-עולמים בבית-הקברות הצבאי בקרית ענבים. אחרי מותו הועלה
								לדרגת סגן.
							</p>
							<div>
							<img style="width: 200px;"
					src="http://www.izkor.mod.gov.il/Data/korot/Image/091678.jpg" />
							<img
						style="width: 400px;"
						src="//static.wixstatic.com/media/d7f977_1eab1d12e2b84718957092a4d62dea4e.jpg" /></div>
					</div></td>
			</tr>
	 */
	
	private static String createTableRowV2(SingleRecord singleRecord, int index) throws MalformedURLException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>");
		sb.append(System.getProperty("line.separator"));
		sb.append("<td>");
		sb.append(System.getProperty("line.separator"));
		sb.append("<a href=\"#myPopup" + String.valueOf(index)
				+ "\"	data-rel=\"popup\" class=\"ui-btn ui-btn-inline ui-corner-all\"  style=\"font-size:70px;\">");
		sb.append(System.getProperty("line.separator"));
		sb.append(singleRecord.getFullName() + "&nbsp&nbsp<img  style=\"width: 200px;\" src=\"" + singleRecord.getFaceImage() + "\" />" + "</a>");
		sb.append(System.getProperty("line.separator"));
		sb.append("<div data-role=\"popup\" id=\"myPopup" + String.valueOf(index) + "\" class=\"ui-content\">");
		sb.append(System.getProperty("line.separator"));
		sb
				.append("<a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>");
		sb.append("<h1>" + singleRecord.getFullName() + "</h1>");
		sb.append(System.getProperty("line.separator"));
		sb.append(getDescription(singleRecord.getId()));
		sb.append(System.getProperty("line.separator"));
		sb.append("<div>");
		sb.append(System.getProperty("line.separator"));
		sb.append("<img  style=\"width:200px;\" src=\"" + singleRecord.getFaceImage() + "\" />");
		sb.append("&nbsp&nbsp");
		sb.append("<img  style=\"width:400px;\" src=\"" + singleRecord.getTumbImage() + "\" />");
		sb.append("</div>");
		sb.append(System.getProperty("line.separator"));
		sb.append("</div>");
		sb.append(System.getProperty("line.separator"));
		sb.append("</td>");
		sb.append(System.getProperty("line.separator"));
		sb.append("</tr>");
		
		return sb.toString();
	}
	
	private static String getDescription(int halalId) throws MalformedURLException, IOException {
		URL url = new URL("http://www.izkor.mod.gov.il/HalalKorot_Print.aspx?id=" + halalId);
		Document doc = Jsoup.parse(url, 1000000);
		Elements paragraps = doc.select("p");
		paragraps.remove(0);
		return "<article style=\"overflow-y: scroll;\">".concat(paragraps.toString().concat("</article>"));
	}
	
	private static List<SingleRecord> createList() {
		
		List<SingleRecord> hal = new ArrayList<SingleRecord>();
		hal.add(new SingleRecord(91678, "אהרן-דב פיגנבלט", "//static.wixstatic.com/media/d7f977_1eab1d12e2b84718957092a4d62dea4e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091678.jpg"));
		hal.add(new SingleRecord(92265, "אהרן שמי", "//static.wixstatic.com/media/d7f977_65d44a5b3d1d4118aa494947569b213f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092265.jpg"));
		hal.add(new SingleRecord(40117, "אריה-חיים ולד", "//static.wixstatic.com/media/d7f977_8a3d0dc058024dc998ef188ca7ab1404.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/040117.jpg"));
		hal.add(new SingleRecord(7568, "אריה חיקינד-טוקצ'רוב", "//static.wixstatic.com/media/d7f977_2ea3e8621eb5488a929c9b2f91c86d5d.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007568.jpg"));
		hal.add(new SingleRecord(4333, "בן-ציון מאיר", "//static.wixstatic.com/media/d7f977_4605e9a9d4974efa9081213e0a3e8f53.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004333.jpg"));
		hal.add(new SingleRecord(8545, "בנימין-נפתלי רבינוביץ", "//static.wixstatic.com/media/d7f977_cd7af4329d67411c82264ba0f03fc5a5.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008545.jpg"));
		hal.add(new SingleRecord(23287, "גבריאל שפטר", "//static.wixstatic.com/media/d7f977_d86a802915704aee944bf199929814f1.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023287.jpg"));
		hal.add(new SingleRecord(7380, "דב גרייצר", "//static.wixstatic.com/media/d7f977_a2c5e370baa746ad825d0100983f404f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007380.jpg"));
		hal.add(new SingleRecord(92209, "דוד-לייב שטרן", "//static.wixstatic.com/media/d7f977_54a15af907a0454581b1faba68b16d9a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092209.jpg"));
		hal.add(new SingleRecord(44274, "יוסף מלח", "//static.wixstatic.com/media/d7f977_96f9662c37a444a9ab4ae827e16d9325.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044274.jpg"));
		hal.add(new SingleRecord(91896, "יוסף קונטי", "//static.wixstatic.com/media/d7f977_0790209bb37048709fbd49136c0525a6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091896.jpg"));
		hal.add(new SingleRecord(4078, "יעקב-רפאל סולוביץ", "//static.wixstatic.com/media/d7f977_db559d687ec9468187c118ba73dd8fe5.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004078.jpg"));
		hal.add(new SingleRecord(88054, "יצחק-אייזיק דואה", "//static.wixstatic.com/media/d7f977_f0de8ada03654323866a3b637fb5a1f9.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088054.jpg"));
		hal.add(new SingleRecord(8014, "יצחק דיין", "//static.wixstatic.com/media/d7f977_6508479526454fd49c8c9a8a7352b737.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008014.jpg"));
		hal.add(new SingleRecord(92310, "יצחק מרדכי", "//static.wixstatic.com/media/d7f977_25a6373f7e334321adada1fd644bd9d1.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092310.jpg"));
		hal.add(new SingleRecord(98402, "ירדן בן נריה", "//static.wixstatic.com/media/d7f977_cce8a408e1b94fec915b2202c0269a74.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/098402.jpg"));
		hal.add(new SingleRecord(4693, "יריב שינבוים", "//static.wixstatic.com/media/d7f977_f37814f259c3446d9a349289c6f7a0f7.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004693.jpg"));
		hal.add(new SingleRecord(23573, "ישראל שוורץ", "//static.wixstatic.com/media/d7f977_633aa98acfee46faa23f6d037c8277ee.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023573.jpg"));
		hal.add(new SingleRecord(7449, "מישאל פינסקר", "//static.wixstatic.com/media/d7f977_279e4eb88eec4b2691190301e9d5cd5a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007449.jpg"));
		hal.add(new SingleRecord(44057, "מרדכי עדס", "//static.wixstatic.com/media/d7f977_31d9b7b3c2724db5a32be06f93bcaaf9.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044057.jpg"));
		hal.add(new SingleRecord(88203, "משה חרש", "//static.wixstatic.com/media/d7f977_7f3663a5059c4c44b2e82956c76d73c2.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088203.jpg"));
		hal.add(new SingleRecord(93668, "עופר  בן-נריה", "//static.wixstatic.com/media/d7f977_495d8f8c804d448798d1addd209c8631.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/093668.jpg"));
		hal.add(new SingleRecord(88981, "עזריה מרימצ'יק", "//static.wixstatic.com/media/d7f977_42956ed17bf244a5aaa3f135975ff037.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088981.jpg"));
		hal.add(new SingleRecord(7224, "עמי-חי אורלינסקי", "//static.wixstatic.com/media/d7f977_4aebb0c3ebfd480bacf6ed5eefe8aad4.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007224.jpg"));
		hal.add(new SingleRecord(46270, "עמיאל רוז'נסקי", "//static.wixstatic.com/media/d7f977_c9e77fa443da45a5afa020242cea652c.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/046270.jpg"));
		hal.add(new SingleRecord(47191, "פנחס נירי", "//static.wixstatic.com/media/d7f977_9e0a4f3fc8324a2f8df3c6008b1393a5.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/047191.jpg"));
		hal.add(new SingleRecord(7045, "צבי-זאב מאיר", "//static.wixstatic.com/media/d7f977_b13fee8af05e49a79af2866bd9e95bf1.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007045.jpg"));
		hal.add(new SingleRecord(88444, "צבי-משה אלישווילי", "//static.wixstatic.com/media/d7f977_a4de44033b384295b88a804e3f296582.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088444.jpg"));
		hal.add(new SingleRecord(90858, "רפאל זילברמן", "//static.wixstatic.com/media/d7f977_4172cd6036114e4d8e9fc14cbd15910e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090858.jpg"));
		hal.add(new SingleRecord(91269, "רפאל לידג'י", "//static.wixstatic.com/media/d7f977_18c2cfb231684a749981ef7355956882.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091269.jpg"));
		hal.add(new SingleRecord(90779, "שמואל וילנצ'וק", "//static.wixstatic.com/media/d7f977_e83efe91b0c24e7d9e8dc8e19faea327.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090779.jpg"));
		hal.add(new SingleRecord(94648, "שמואל ניפומנישצ'י", "//static.wixstatic.com/media/d7f977_3c79dc9ce86f4023a208f647182c84b4.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/094648.jpg"));
		hal.add(new SingleRecord(505038, "אברהם דגן", "//static.wixstatic.com/media/d7f977_08b81bfdb18a438a825a29559c11e811.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/505038.jpg"));
		hal.add(new SingleRecord(96013, "פנחס פרישברג", "//static.wixstatic.com/media/d7f977_1d45475a3f694333afbebc0153551cb6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/096013.jpg"));
		hal.add(new SingleRecord(95816, "אריה בדש", "//static.wixstatic.com/media/d7f977_5f1270be82c9423f8f2410fe4e7b805f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/095816.jpg"));
		hal.add(new SingleRecord(94842, "איתמר גולבס", "//static.wixstatic.com/media/d7f977_8781c1e419034ebc8cd235c708bda66c.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/094842.jpg"));
		hal.add(new SingleRecord(94264, "עמי-יעל אקסלרוד", "//static.wixstatic.com/media/d7f977_84a4d423c758448198b510a77660a4be.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/094264.jpg"));
		hal.add(new SingleRecord(93240, "אהוד טויב", "//static.wixstatic.com/media/d7f977_3693dfa0ef184e678059aa23d00cd8d8.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/093240.jpg"));
		hal.add(new SingleRecord(92774, "שלמה בכר", "//static.wixstatic.com/media/d7f977_24a026c76a264ddcb4b2538da3d574f2.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092774.jpg"));
		hal.add(new SingleRecord(92297, "ישראל שפירא", "//static.wixstatic.com/media/d7f977_ad722b5e5dae4c518084bbdde6a60157.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092297.jpg"));
		hal.add(new SingleRecord(92221, "צבי שיוביץ", "//static.wixstatic.com/media/d7f977_12536f93189d4fe384bb7cf5d3e1ded5.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092221.jpg"));
		hal.add(new SingleRecord(92215, "שמשון שטרנג", "//static.wixstatic.com/media/d7f977_3ba1d4583740489c9fc3af0553598269.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092215.jpg"));
		hal.add(new SingleRecord(92150, "אריה שולר", "//static.wixstatic.com/media/d7f977_d4212d8bea99434cbb5cbdd9db3bccf8.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092150.jpg"));
		hal.add(new SingleRecord(92113, "יקותיאל רינמן", "//static.wixstatic.com/media/d7f977_4af8ffe8937e40229d22339e8bc5580b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092113.jpg"));
		hal.add(new SingleRecord(92097, "יוסף ריטיגשטיין", "//static.wixstatic.com/media/d7f977_49b557a57dd849ccad37d3f8b7f400ae.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/092097.jpg"));
		hal.add(new SingleRecord(91917, "נתנאל קורנהויזר", "//static.wixstatic.com/media/d7f977_9a7f09fbbba24c6fac88b024e7cf7d6a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091917.jpg"));
		hal.add(new SingleRecord(91909, "חיים קופרמן", "//static.wixstatic.com/media/d7f977_444123ec87fd4895b866b00d3d2342ff.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091909.jpg"));
		hal.add(new SingleRecord(91817, "מרדכי פרנקו", "//static.wixstatic.com/media/d7f977_0bb5c5ec219a4834882dbfd233d261cf.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091817.jpg"));
		hal.add(new SingleRecord(91716, "גדעון פלאי", "//static.wixstatic.com/media/d7f977_d722bcb2236a4f858b0711937af07321.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091716.jpg"));
		hal.add(new SingleRecord(91646, "חיים פוזננסקי", "//static.wixstatic.com/media/d7f977_fd65ca07ae6a4e32b892ee0b5632175b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091646.jpg"));
		hal.add(new SingleRecord(91645, "נדב פוגל", "//static.wixstatic.com/media/d7f977_2ed5028ac6d24d16b11da1f2c828aa92.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091645.jpg"));
		hal.add(new SingleRecord(91567, "יעקב סמקובסקי", "//static.wixstatic.com/media/d7f977_b22827dc5c424a459b51a5e6ffbaa39f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091567.jpg"));
		hal.add(new SingleRecord(91419, "יוסף מנין", "//static.wixstatic.com/media/d7f977_6e17a8c613a447e49e0def7ec418f577.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091419.jpg"));
		hal.add(new SingleRecord(91253, "סומר לופו", "//static.wixstatic.com/media/d7f977_cef20c5e39dd4201ac92771b53a79a2a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091253.jpg"));
		hal.add(new SingleRecord(91250, "רחמים לוי-שאשו", "//static.wixstatic.com/media/d7f977_8a3fa5f4bdf44f7cb6e4080095eee7c4.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091250.jpg"));
		hal.add(new SingleRecord(91237, "אביגדור לוין", "//static.wixstatic.com/media/d7f977_cec971179f384205aaf70dbfb4296b94.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091237.jpg"));
		hal.add(new SingleRecord(91176, "אמנון כרמי", "//static.wixstatic.com/media/d7f977_1347bee63a6d4809830166fddd49f80f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091176.jpg"));
		hal.add(new SingleRecord(91125, "נחמיה כהן", "//static.wixstatic.com/media/d7f977_a54b5a69d69a4d8ba4c9ed693a639192.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091125.jpg"));
		hal.add(new SingleRecord(91086, "יעקב ישראלית", "//static.wixstatic.com/media/d7f977_1412706df24f4c2da7d8c8f131869cdf.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091086.jpg"));
		hal.add(new SingleRecord(91074, "ישראל ירוסט", "//static.wixstatic.com/media/d7f977_b340947c720c4c07864ecca16a8c22a5.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/091074.jpg"));
		hal.add(new SingleRecord(90995, "מאיר טפר", "//static.wixstatic.com/media/d7f977_fcb0b15d151e435d892ee08414277bb5.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090995.jpg"));
		hal.add(new SingleRecord(90993, "אברהם טפר", "//static.wixstatic.com/media/d7f977_2af3b911af084a5f8842489b9fd86615.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090993.jpg"));
		hal.add(new SingleRecord(90954, "משה טוכמן", "//static.wixstatic.com/media/d7f977_78fc0cfa0f504f7ca8c6a6fbaa588a0b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090954.jpg"));
		hal.add(new SingleRecord(90873, "בנימין זיס", "//static.wixstatic.com/media/d7f977_dcbf4b7a6b2f4b7a82011729272edea9.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090873.jpg"));
		hal.add(new SingleRecord(90727, "מאיר הרכבי", "//static.wixstatic.com/media/d7f977_dce677d8d50845c1ae74507bc0a0dc58.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090727.jpg"));
		hal.add(new SingleRecord(90621, "שלום דינר", "//static.wixstatic.com/media/d7f977_fd3608ae487b4edba46a217caf90083f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090621.jpg"));
		hal.add(new SingleRecord(90614, "פרץ דיטריך", "//static.wixstatic.com/media/d7f977_1dc1d16b31514036aaccf47805fee16e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090614.jpg"));
		hal.add(new SingleRecord(90602, "יצחק דויטשר", "//static.wixstatic.com/media/d7f977_0576c5221dc94e079ce2727e40481d1d.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090602.jpg"));
		hal.add(new SingleRecord(90578, "אריה דובוב", "//static.wixstatic.com/media/d7f977_eb1af3f4714741368e992b32cf7e00bd.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090578.jpg"));
		hal.add(new SingleRecord(90577, "שמואל דובו", "//static.wixstatic.com/media/d7f977_f56176a31ef84505b721977cff9a3791.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090577.jpg"));
		hal.add(new SingleRecord(90568, "משה גרשוביץ", "//static.wixstatic.com/media/d7f977_7860873415744fd8a944df74db3deb71.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090568.jpg"));
		hal.add(new SingleRecord(90365, "בני ברלה", "//static.wixstatic.com/media/d7f977_28af5fe737a84cb4b33fb6b92d50d879.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090365.jpg"));
		hal.add(new SingleRecord(90229, "יעקב בולדה", "//static.wixstatic.com/media/d7f977_09766e0d01744fa58bd9824ad0630745.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/090229.jpg"));
		hal.add(new SingleRecord(88979, "נחום אריאלי", "//static.wixstatic.com/media/d7f977_f4aab561cb6941b6bb425251eec69c39.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088979.jpg"));
		hal.add(new SingleRecord(88928, "דניאל בוקשטיין", "//static.wixstatic.com/media/d7f977_7fa40d3ca21840fa841e2554128cff3b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088928.jpg"));
		hal.add(new SingleRecord(88894, "מיכאל קליין", "//static.wixstatic.com/media/d7f977_a15cfa5c527a486dbd0c131b509e1a8f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088894.jpg"));
		hal.add(new SingleRecord(88893, "יצחק זינגר", "//static.wixstatic.com/media/d7f977_9de17e6ee9a44e92b52ace48c3ade997.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088893.jpg"));
		hal.add(new SingleRecord(88866, "יוסף קופלוביץ", "//static.wixstatic.com/media/d7f977_3f6a1a4d30e745d0b776e85077873eee.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088866.jpg"));
		hal.add(new SingleRecord(88810, "צבי מונש", "//static.wixstatic.com/media/d7f977_19beb2eb8de84b04a97b5b64ad1ad75c.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088810.jpg"));
		hal.add(new SingleRecord(88803, "הנס גלוזמן", "//static.wixstatic.com/media/d7f977_a5bd69bcd18f4c55a86adc5b6a40a3df.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088803.jpg"));
		hal.add(new SingleRecord(88606, "יוסף סימבול", "//static.wixstatic.com/media/d7f977_6a87c77fa4ab4537964d316fdb460e64.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088606.jpg"));
		hal.add(new SingleRecord(88602, "יעקב לוי", "//static.wixstatic.com/media/d7f977_95f9fb5afba64274b4b57b6eec029c09.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088602.jpg"));
		hal.add(new SingleRecord(88550, "שלמה כהן", "//static.wixstatic.com/media/d7f977_36194ce56b634470b99f7e3729ae7d3b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088550.jpg"));
		hal.add(new SingleRecord(88526, "יצחק כהן", "//static.wixstatic.com/media/d7f977_391fa8ea23eb43c3be5d9dfef2042f6a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088526.jpg"));
		hal.add(new SingleRecord(88479, "דוד וינברג", "//static.wixstatic.com/media/d7f977_7f5cfa40a3b64837b949a6c918fdb068.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088479.jpg"));
		hal.add(new SingleRecord(88453, "יהודה שרעבי", "//static.wixstatic.com/media/d7f977_d3f47e1217a543499e262df1d39f9993.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088453.jpg"));
		hal.add(new SingleRecord(88277, "שלום פינקלשטיין", "//static.wixstatic.com/media/d7f977_d56c3eab76514f7facb1920f65a9e7f9.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088277.jpg"));
		hal.add(new SingleRecord(88262, "זכריה משה", "//static.wixstatic.com/media/d7f977_4f5bc82d45ee496fa686b222b9f8237e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088262.jpg"));
		hal.add(new SingleRecord(88161, "מרדכי בורנשטיין", "//static.wixstatic.com/media/d7f977_4d7f19a9bf234049b496857766d5a0e8.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088161.jpg"));
		hal.add(new SingleRecord(88061, "יצחק פרנקו", "//static.wixstatic.com/media/d7f977_d2e6b157110d47aca506ba54ad44ae41.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088061.jpg"));
		hal.add(new SingleRecord(88040, "מרדכי לוקר", "//static.wixstatic.com/media/d7f977_77e92e93859e4d30b20ef059fda4b2d6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088040.jpg"));
		hal.add(new SingleRecord(88035, "סנדר גרינברג", "//static.wixstatic.com/media/d7f977_53f5ec5710b24f68989c38c6d2727912.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/088035.jpg"));
		hal.add(new SingleRecord(77091, "מיכאל קוטיק", "//static.wixstatic.com/media/d7f977_481949f3f9b7486fad03ccfeb6824b2b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/077091.jpg"));
		hal.add(new SingleRecord(47297, "רפאל מלץ", "//static.wixstatic.com/media/d7f977_391efcad843141e390ccf044a9852715.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/047297.jpg"));
		hal.add(new SingleRecord(47177, "אופיר אנקורי", "//static.wixstatic.com/media/d7f977_dd44ab746bd54988a407ef2dbfa0584b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/047177.jpg"));
		hal.add(new SingleRecord(47011, "יונתן ברוזה", "//static.wixstatic.com/media/d7f977_ab5f5456bee34e23ad276ab517f01ad4.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/047011.jpg"));
		hal.add(new SingleRecord(46972, "אברהם ויסר", "//static.wixstatic.com/media/d7f977_6061a2762b3f46c48abfe4a48a5c046e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/046972.jpg"));
		hal.add(new SingleRecord(46651, "זלמן פופלבסקי", "//static.wixstatic.com/media/d7f977_99b73bf5821e4518b857c7be1515cc5e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/046651.jpg"));
		hal.add(new SingleRecord(46567, "עמוס בן-אריה", "//static.wixstatic.com/media/d7f977_e19ebf95365040c286019d37dc049d52.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/046567.jpg"));
		hal.add(new SingleRecord(46391, "דוד-נפתלי מרמור", "//static.wixstatic.com/media/d7f977_cdac94e2cf1b4f97b33c7440173797c7.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/046391.jpg"));
		hal.add(new SingleRecord(46028, "מנחם קופמן", "//static.wixstatic.com/media/d7f977_9e985f3c0067497aa580e0a34073a9f1.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/046028.jpg"));
		hal.add(new SingleRecord(45333, "יעקב אבטיחי", "//static.wixstatic.com/media/d7f977_9397980450a34f75b0f47b4920548df3.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/045333.jpg"));
		hal.add(new SingleRecord(45194, "ישראל גרינפלד", "//static.wixstatic.com/media/d7f977_f2d1767e4d3d4347a1b2df93eaf3c150.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/045194.jpg"));
		hal.add(new SingleRecord(45166, "צפריר כרמלי", "//static.wixstatic.com/media/d7f977_797d8a630e9d40ee9126c654850fbd41.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/045166.jpg"));
		hal.add(new SingleRecord(45158, "מיכאל שפניר", "//static.wixstatic.com/media/d7f977_6b20b37222b8406e9bd0030e37f30e3a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/045158.jpg"));
		hal.add(new SingleRecord(44779, "אבנר זילברמן", "//static.wixstatic.com/media/d7f977_b60450f84c99457ab2d0803fe23fa80c.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044779.jpg"));
		hal.add(new SingleRecord(44708, "יעקב סוקולובסקי", "//static.wixstatic.com/media/d7f977_312c6d355d8c4987a9279fae6ced6958.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044708.jpg"));
		hal.add(new SingleRecord(44623, "צבי שוסטרמן", "//static.wixstatic.com/media/d7f977_8bdf99e151a345d39ffc0b6686b82b54.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044623.jpg"));
		hal.add(new SingleRecord(44154, "נדב ויסמן", "//static.wixstatic.com/media/d7f977_47ab1e95d3314ba2ba8e19ff7bf33fa7.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044154.jpg"));
		hal.add(new SingleRecord(44077, "אריה בלומברג", "//static.wixstatic.com/media/d7f977_687a57091272430b875e90ee177bf403.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044077.jpg"));
		hal.add(new SingleRecord(44027, "ראובן וקר", "//static.wixstatic.com/media/d7f977_646139939b2648d5b6de16bef108a67c.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/044027.jpg"));
		hal.add(new SingleRecord(40113, "יוסף גוטמן", "//static.wixstatic.com/media/d7f977_589de8eaf5574baaa8e37399b9d23d17.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/040113.jpg"));
		hal.add(new SingleRecord(23692, "בן-ציון מזרחי", "//static.wixstatic.com/media/d7f977_7cd083b59d424eb09b704af92f814ecb.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023692.jpg"));
		hal.add(new SingleRecord(23664, "יוסף ויס", "//static.wixstatic.com/media/d7f977_4cc4e30d34cb41cab65bf0b2fea62d1b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023664.jpg"));
		hal.add(new SingleRecord(23594, "יעקב קינדרמן", "//static.wixstatic.com/media/d7f977_a3d3c3e9b7f54d1f8e976e38514d7c41.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023594.jpg"));
		hal.add(new SingleRecord(23543, "שלמה מנדל", "//static.wixstatic.com/media/d7f977_536e3abf40f34a8d8c9a3c82a19a933f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023543.jpg"));
		hal.add(new SingleRecord(23541, "יצחק וינגרוביץ", "//static.wixstatic.com/media/d7f977_0c4290f22bcb467395f95cc0e98cce22.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/023541.jpg"));
		hal.add(new SingleRecord(8524, "סימן-טוב מזרחי", "//static.wixstatic.com/media/d7f977_410d9df7b7b54d6c836f811127a085b6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008524.jpg"));
		hal.add(new SingleRecord(8479, "אהרן גולדנברג", "//static.wixstatic.com/media/d7f977_e1d97d45a760435d91a4847ebcbf5a10.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008479.jpg"));
		hal.add(new SingleRecord(8249, "שמואל מיכאלוף", "//static.wixstatic.com/media/d7f977_fb5fe5a14ce44d0f9992830b56edbb17.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008249.jpg"));
		hal.add(new SingleRecord(8143, "רחמים יגן", "//static.wixstatic.com/media/d7f977_d7303434357f4375a659cbe376202f12.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008143.jpg"));
		hal.add(new SingleRecord(8005, "ידידיה חבקין", "//static.wixstatic.com/media/d7f977_5714bfb467f84e319a8b14868c5bf505.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/008005.jpg"));
		hal.add(new SingleRecord(7710, "שלמה רוטשטיין", "//static.wixstatic.com/media/d7f977_454c3f1f1eaf4579a55790f642531445.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007710.jpg"));
		hal.add(new SingleRecord(7707, "יעקב סטוצקי", "//static.wixstatic.com/media/d7f977_bb9e50ef4a58417b9399357b4dfec4e6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007707.jpg"));
		hal.add(new SingleRecord(7634, "יוסף לקס", "//static.wixstatic.com/media/d7f977_0d1fc525bf344d2ebe40e8d8879b7df6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007634.jpg"));
		hal.add(new SingleRecord(7601, "אריה יונג", "//static.wixstatic.com/media/d7f977_51de725b38af47018142b7547592fe70.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007601.jpg"));
		hal.add(new SingleRecord(7445, "יעקב רוזנבאום", "//static.wixstatic.com/media/d7f977_81dd7c6def0d4c8b86cdf1f2bb87e8db.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007445.jpg"));
		hal.add(new SingleRecord(7402, "אבנר קוטיגרו", "//static.wixstatic.com/media/d7f977_13ac5afe808044ef9f1ae2d39b49fb17.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007402.jpg"));
		hal.add(new SingleRecord(7316, "נחום בראד", "//static.wixstatic.com/media/d7f977_4b731dc882244843a9685945fd654f16.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007316.jpg"));
		hal.add(new SingleRecord(7296, "אורי קוסטקובסקי", "//static.wixstatic.com/media/d7f977_e9f96965a31743fa818836ee95da4630.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007296.jpg"));
		hal.add(new SingleRecord(7061, "מרדכי יהודה", "//static.wixstatic.com/media/d7f977_6c9fbc0f25124075b15292d2c5567a8f.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007061.jpg"));
		hal.add(new SingleRecord(7043, "לוי שפיגלמן", "//static.wixstatic.com/media/d7f977_e0da3724bad14900a26643407bc06ff8.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/007043.jpg"));
		hal.add(new SingleRecord(4948, "יעקב זרחי", "//static.wixstatic.com/media/d7f977_6bec32e5e20343cf859bcdbc08cb32c6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004948.jpg"));
		hal.add(new SingleRecord(4941, "נח טייכנר", "//static.wixstatic.com/media/d7f977_33aa22cecb3a405daf157722e9446fdb.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004941.jpg"));
		hal.add(new SingleRecord(4815, "אביתר פרלמוטר", "//static.wixstatic.com/media/d7f977_09b16ade35f9459eb4a86427e67948ec.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004815.jpg"));
		hal.add(new SingleRecord(4808, "אריה אלקלעי", "//static.wixstatic.com/media/d7f977_0116814b638a4c0a850330338ba40f45.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004808.jpg"));
		hal.add(new SingleRecord(4804, "שמואל אשכנזי", "//static.wixstatic.com/media/d7f977_a7de018dedf643499dadb8c16e88450d.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004804.jpg"));
		hal.add(new SingleRecord(4745, "שמעון שופטן", "//static.wixstatic.com/media/d7f977_a494a174d6814f41b8f813848903982b.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004745.jpg"));
		hal.add(new SingleRecord(4694, "יצחק יעקבי", "//static.wixstatic.com/media/d7f977_3406b7b9280249d3b94351224007ff88.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004694.jpg"));
		hal.add(new SingleRecord(4653, "אליהו רובין", "//static.wixstatic.com/media/d7f977_17e24cdf6ec540bcb918f1f6587805a6.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004653.jpg"));
		hal.add(new SingleRecord(4613, "דן שטרן", "//static.wixstatic.com/media/d7f977_240d4c32993844cc9183bd2b9a4cd861.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004613.jpg"));
		hal.add(new SingleRecord(4611, "שמואל מזרחי", "//static.wixstatic.com/media/d7f977_46ed741889864f2cac376fdc82140c85.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004611.jpg"));
		hal.add(new SingleRecord(4582, "דוד תם", "//static.wixstatic.com/media/d7f977_76d6b405a52a448f86db8b9787f68b66.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004582.jpg"));
		hal.add(new SingleRecord(4514, "מרדכי אביכזר", "//static.wixstatic.com/media/d7f977_4a00219c9d964a52ab75784b64a68905.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004514.jpg"));
		hal.add(new SingleRecord(4473, "מנחם אסא", "//static.wixstatic.com/media/d7f977_be43dee2316d4a2e83c2f7fa970a067d.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004473.jpg"));
		hal.add(new SingleRecord(4444, "ישראל דניאל", "//static.wixstatic.com/media/d7f977_00f4ca82b2144901877893e732044d28.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004444.jpg"));
		hal.add(new SingleRecord(4324, "שמואל נפרסטק", "//static.wixstatic.com/media/d7f977_916251e17d7841fb9a600f5ed435a0ee.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004324.jpg"));
		hal.add(new SingleRecord(4244, "אפרים וידן", "//static.wixstatic.com/media/d7f977_7b9a426105424ebdad01f9b994b384a9.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004244.jpg"));
		hal.add(new SingleRecord(4235, "צבי קנטור", "//static.wixstatic.com/media/d7f977_0a221b38b82e4809908e5e4f4bf69be3.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004235.jpg"));
		hal.add(new SingleRecord(4129, "ברוך רז", "//static.wixstatic.com/media/d7f977_392d57076b8844b0ac1b09f615df387e.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004129.jpg"));
		hal.add(new SingleRecord(4120, "מאיר אקריש", "//static.wixstatic.com/media/d7f977_119b93d85766439f926cbcc88bafb3d3.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004120.jpg"));
		hal.add(new SingleRecord(4106, "שמעון משולם", "//static.wixstatic.com/media/d7f977_44cd6eb56ccd4adcbfe4fb86ee7099f3.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004106.jpg"));
		hal.add(new SingleRecord(4058, "יעקב בכר", "//static.wixstatic.com/media/d7f977_56ef9654886e47ba9e33dc36abce70be.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004058.jpg"));
		hal.add(new SingleRecord(4029, "משה לוי", "//static.wixstatic.com/media/d7f977_1222f13145b7427a953c4f0c5925608a.jpg",
				"http://www.izkor.mod.gov.il/Data/korot/Image/004029.jpg"));
		
		return hal;
	}
	
}
