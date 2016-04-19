
package chat.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object connectClient extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""
"""),format.raw/*2.1*/("""<script language="javascript" type="text/javascript">
	var wsUri = """"),_display_(/*3.16*/chat/*3.20*/.routes.Chat.socket().webSocketURL()),format.raw/*3.56*/("""";
	var output;
	var input;
	var websocket;
	function init() """),format.raw/*7.18*/("""{"""),format.raw/*7.19*/("""
		"""),format.raw/*8.3*/("""output = document.getElementById("output");
		input = document.getElementById("input");
		connect();
	"""),format.raw/*11.2*/("""}"""),format.raw/*11.3*/("""

	"""),format.raw/*13.2*/("""function connect() """),format.raw/*13.21*/("""{"""),format.raw/*13.22*/("""
		"""),format.raw/*14.3*/("""websocket = new WebSocket(wsUri);

		websocket.onopen = function(evt) """),format.raw/*16.36*/("""{"""),format.raw/*16.37*/("""
			"""),format.raw/*17.4*/("""onOpen(evt)
		"""),format.raw/*18.3*/("""}"""),format.raw/*18.4*/(""";

		websocket.onclose = function(evt) """),format.raw/*20.37*/("""{"""),format.raw/*20.38*/("""
			"""),format.raw/*21.4*/("""onClose(evt)
		"""),format.raw/*22.3*/("""}"""),format.raw/*22.4*/(""";

		websocket.onmessage = function(evt) """),format.raw/*24.39*/("""{"""),format.raw/*24.40*/("""
			"""),format.raw/*25.4*/("""onMessage(evt)
		"""),format.raw/*26.3*/("""}"""),format.raw/*26.4*/(""";

		websocket.onerror = function(evt) """),format.raw/*28.37*/("""{"""),format.raw/*28.38*/("""
			"""),format.raw/*29.4*/("""onError(evt)
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""";
	"""),format.raw/*31.2*/("""}"""),format.raw/*31.3*/("""

	"""),format.raw/*33.2*/("""function onOpen(evt) """),format.raw/*33.23*/("""{"""),format.raw/*33.24*/("""
		"""),format.raw/*34.3*/("""websocket.send(""""),_display_(/*34.20*/name),format.raw/*34.24*/("""");
		systemMessage("Connected as """),_display_(/*35.32*/name),format.raw/*35.36*/("""");
	"""),format.raw/*36.2*/("""}"""),format.raw/*36.3*/("""

	"""),format.raw/*38.2*/("""function onClose(evt) """),format.raw/*38.24*/("""{"""),format.raw/*38.25*/("""
		"""),format.raw/*39.3*/("""systemMessage("Disconnected");
	"""),format.raw/*40.2*/("""}"""),format.raw/*40.3*/("""

	"""),format.raw/*42.2*/("""function onMessage(evt) """),format.raw/*42.26*/("""{"""),format.raw/*42.27*/("""
		"""),format.raw/*43.3*/("""var message = evt.data;

		if(message.charAt(0)=='%') """),format.raw/*45.30*/("""{"""),format.raw/*45.31*/("""
			"""),format.raw/*46.4*/("""systemMessage(message.substring(1));
			return;
		"""),format.raw/*48.3*/("""}"""),format.raw/*48.4*/("""

		"""),format.raw/*50.3*/("""writeToScreen('<span style="color: white;">' + message +'</span>');
		//websocket.close();
	"""),format.raw/*52.2*/("""}"""),format.raw/*52.3*/("""

	"""),format.raw/*54.2*/("""function onError(evt) """),format.raw/*54.24*/("""{"""),format.raw/*54.25*/("""
		"""),format.raw/*55.3*/("""writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
	"""),format.raw/*56.2*/("""}"""),format.raw/*56.3*/("""

	"""),format.raw/*58.2*/("""function submit() """),format.raw/*58.20*/("""{"""),format.raw/*58.21*/("""
		"""),format.raw/*59.3*/("""doSend(input.value.replace(/&/g,'&amp;' ).replace(/>/g,'&gt;' ).replace(/</g,'&lt;' ).replace(/"/g,'&quot;'));
		input.value = '';
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/("""

	"""),format.raw/*63.2*/("""function doSend(message) """),format.raw/*63.27*/("""{"""),format.raw/*63.28*/("""
		"""),format.raw/*64.3*/("""writeToScreen('<span style="color: blue;">' + message +'</span>');
		websocket.send(message);
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/("""

	"""),format.raw/*68.2*/("""function systemMessage(message) """),format.raw/*68.34*/("""{"""),format.raw/*68.35*/("""
		"""),format.raw/*69.3*/("""writeToScreen('<span style="color: darkgray;">' + message +'</span>');
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/("""

	"""),format.raw/*72.2*/("""function writeToScreen(message) """),format.raw/*72.34*/("""{"""),format.raw/*72.35*/("""
		"""),format.raw/*73.3*/("""var pre = document.createElement("p");
		pre.style.wordWrap = "break-word";
		pre.innerHTML = message;
		output.appendChild(pre);
	"""),format.raw/*77.2*/("""}"""),format.raw/*77.3*/("""

	"""),format.raw/*79.2*/("""window.addEventListener("load", init, false);
</script>
<div class="container">
	<div class="white-box">
		<h1 style="text-align: center;">Hybrida Chat</h1>
		<div id="output"></div>
		<textarea placeholder="Skriv inn konstruktiv kritikk her" rows="4" cols="50" id="input"></textarea>
		<br />
		<button onclick="submit()">Del visdom</button>
	</div>
</div>

"""))}
  }

  def render(name:String): play.twirl.api.HtmlFormat.Appendable = apply(name)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (name) => apply(name)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/chat/views/connectClient.scala.html
                  HASH: e6792ff1d8714dcf66a620178690c9ba639dc09c
                  MATRIX: 736->1|838->15|866->17|962->87|974->91|1030->127|1122->192|1150->193|1180->197|1312->302|1340->303|1372->308|1419->327|1448->328|1479->332|1579->404|1608->405|1640->410|1682->425|1710->426|1779->467|1808->468|1840->473|1883->489|1911->490|1982->533|2011->534|2043->539|2088->557|2116->558|2185->599|2214->600|2246->605|2289->621|2317->622|2348->626|2376->627|2408->632|2457->653|2486->654|2517->658|2561->675|2586->679|2649->715|2674->719|2707->725|2735->726|2767->731|2817->753|2846->754|2877->758|2937->791|2965->792|2997->797|3049->821|3078->822|3109->826|3193->882|3222->883|3254->888|3333->940|3361->941|3394->947|3515->1041|3543->1042|3575->1047|3625->1069|3654->1070|3685->1074|3784->1146|3812->1147|3844->1152|3890->1170|3919->1171|3950->1175|4111->1309|4139->1310|4171->1315|4224->1340|4253->1341|4284->1345|4408->1442|4436->1443|4468->1448|4528->1480|4557->1481|4588->1485|4688->1558|4716->1559|4748->1564|4808->1596|4837->1597|4868->1601|5030->1736|5058->1737|5090->1742
                  LINES: 26->1|29->1|30->2|31->3|31->3|31->3|35->7|35->7|36->8|39->11|39->11|41->13|41->13|41->13|42->14|44->16|44->16|45->17|46->18|46->18|48->20|48->20|49->21|50->22|50->22|52->24|52->24|53->25|54->26|54->26|56->28|56->28|57->29|58->30|58->30|59->31|59->31|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|64->36|64->36|66->38|66->38|66->38|67->39|68->40|68->40|70->42|70->42|70->42|71->43|73->45|73->45|74->46|76->48|76->48|78->50|80->52|80->52|82->54|82->54|82->54|83->55|84->56|84->56|86->58|86->58|86->58|87->59|89->61|89->61|91->63|91->63|91->63|92->64|94->66|94->66|96->68|96->68|96->68|97->69|98->70|98->70|100->72|100->72|100->72|101->73|105->77|105->77|107->79
                  -- GENERATED --
              */
          