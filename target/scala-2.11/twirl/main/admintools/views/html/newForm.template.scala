
package admintools.views.html

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
object newForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div style="display: table-row">
	<div style="display: table-cell">Id</div>
	<div style="display: table-cell"> Brukernavn </div>
	<div style="display: table-cell"> Arrkom </div>
	<div style="display: table-cell"> Medlem </div>
	<div style="display: table-cell"> Jentekom </div>
	<div style="display: table-cell"> Redaksjon </div>
	<div style="display: table-cell"> Bedkom </div>
	<div style="display: table-cell"> Vevkom </div>
	<div style="display: table-cell"> Admin </div>
	<div style="display: table-cell"> Kjønn </div>
	<div style="display: table-cell"> Avgangsår </div>
	<div style="display: table-cell"> </div>
	<div style="display: table-cell"> </div>
</div>
<div style="display: table-row">
	<div style="display: table-cell">&mdash;</div>
	<div style="display: table-cell">
		<input class="form-control" type="text" name="username" form="form_new" placeholder="Ny Bruker">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="arrkom" form="form_new">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="member" form="form_new">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="jentekom" form="form_new">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="redaksjonen" form="form_new">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="bedkom" form="form_new">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="vevkom" form="form_new">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="admin" form="form_new">
	</div>
	<div style="display: table-cell">
		<select class="form-control" name="gender" form="form_new">
			<option value="">Ikke satt</option>
			<option value="M" selected>Mann</option>
			<option value="F">Kvinne</option>
		</select>
	</div>
	<div style="display: table-cell">
		<input class="form-control" type="text" name="graduationYear" form="form_new" value=""""),_display_(/*50.89*/(Calendar.getInstance.get(Calendar.YEAR) + 5)),format.raw/*50.134*/("""">
	</div>
	<div style="display: table-cell">
		<input class="btn btn-primary" type="submit" form="form_new">
	</div>
	<div style="display: table-cell">
	</div>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/admintools/views/newForm.scala.html
                  HASH: 30c959d410d0dc8bc263636eb5b52a239c06b383
                  MATRIX: 811->0|2836->1998|2903->2043
                  LINES: 29->1|78->50|78->50
                  -- GENERATED --
              */
          