<%-- 
    Document   : Home
    Created on : Dec 16, 2016, 8:30:49 AM
    Author     : SAHEB GUCHHAIT
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicare</title>
        <style type="text/css">
            /*--------------------------------------------------------------
Accessibility
--------------------------------------------------------------*/
/* Text meant only for screen readers */
.screen-reader-text {
  clip: rect(1px, 1px, 1px, 1px);
  position: absolute !important;
  height: 1px;
  width: 1px;
  overflow: hidden;
}

.screen-reader-text:hover,
.screen-reader-text:active,
.screen-reader-text:focus {
  background-color: #f1f1f1;
  border-radius: 3px;
  box-shadow: 0 0 2px 2px rgba(0, 0, 0, 0.6);
  clip: auto !important;
  color: #21759b;
  display: block;
  font-size: 14px;
  font-weight: bold;
  height: auto;
  left: 5px;
  line-height: normal;
  padding: 15px 23px 14px;
  text-decoration: none;
  top: 5px;
  width: auto;
  z-index: 100000;
}

/*--------------------------------------------------------------
Layouts
--------------------------------------------------------------*/
body {
  background: #ecf0f1;
  line-height: 1.4;
  font-family: sans-serif;
}

.card-content h2 {
  font-size: 2em;
  color: #e74c3c;  
}

.centered {
  margin: 0 auto;
  padding: 0 1em;
}

@media screen and (min-width: 52em) {
  .centered {
    max-width: 60em;
  }
}

/*--------------------------------------------------------------
Header styles minus menu
--------------------------------------------------------------*/
.masthead {
  background-image: url("blog.jpg");
}

.site-title {
  margin: 0 0 1em;
  padding: 1em 0;
  font-size: 2em;
  font-weight: 300;
  text-align: center;
  color: #FFF;
}

@media screen and (min-width: 44.44em) {
  .site-title {
    font-size: 2em;
  }
}

@media screen and (min-width: 50em) {
  .site-title {
    font-size: 2.5em;
  }
}

.site-title a {
  color: hsl(5, 45%, 95%);
  text-decoration: none;
}

.site-title a:hover {
  text-decoration: underline;
}

/*--------------------------------------------------------------
Base styles
--------------------------------------------------------------*/
.site-title {
  margin-bottom: 0;
}

.main-menu {
  padding: .4em 1em;
  color: deeppink;
  background: hsl(0, 0%, 15%);
}

.post-content {
  padding: 0 1.4em 1.4em;
}

.sidebar {
  padding: .5em 1.4em 1em;
  background: hsl(0, 0%, 90%);
  overflow: hidden;
}

.example-menu ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.example-menu a {
  display: block;
  padding: .4em 0;
  color: inherit;
  text-decoration: none;
  transition: all 0.5s ease;
}

.example-menu a:hover,
.example-menu a:focus {
  padding: .4em 1em;
  background: hsl(0, 0%, 20%);
  color: white;
}

.footer-area {
  padding: .4em 1em;
  text-align: center;
  background: hsl(0, 0%, 75%);
}

/* Sidebar switcher buttons */
@media screen and (max-width: 40em) {
  /* Hide switcher on small screens */
  
  .sidebar-switcher {
    display: none;
  }
}

@media screen and (min-width: 40em) {
  .sidebar-switcher {
    position: absolute;
    right: 0;
    padding: .4em 1em;
    color: #FFF;
  }
  .sidebar-switcher a {
    color: #FFF;
    padding-left: .4em;
  }
  .sidebar-switcher a:hover,
  .sidebar-switcher a:focus {
    color: #FFF;
  }
}

/*--------------------------------------------------------------
Flexbox styles
--------------------------------------------------------------*/
@media screen and (min-width: 40em) {
  .outer-wrap {
    display: flex;
    flex-direction: column;
  }
  .content {
    display: flex;
  }
  .post-content {
    max-width: 40em;
    margin: 0 auto;
  }
  .main-area {
    flex: 1 1 auto;
    order: 1;
  }
  .sidebar {
    flex: 0 0 12em;
    order: 2;
  }
  .sidebar-left {
    order: 0;
  }
  .no-sidebar {
    flex-direction: column;
  }
  .hide {
    flex: 0 0 0;
    padding: 0;
    color: hsla(0, 0%, 0%, 0);
    transition: color .2s ease, flex .5s ease .3s, padding .5s ease .3s;
  }
  .hide a {
    color: hsla(0, 0%, 0%, 0);
  }
} /* mq 40em */


/*--------------------------------------------------------------
Base styles that apply to all menu items
--------------------------------------------------------------*/
.menu-section {
  padding-bottom: 2em;
  margin-bottom: 2em;
  border-bottom: 1px solid hsl(0, 0%, 0%);
}

/*--------------------------------------------------------------
Card Based Layout - Base styles
--------------------------------------------------------------*/
.main-area {
  padding: 2em;
}

.card {
  background: white;
  margin-bottom: 2em; 
}

.card a {
  color: black;
  text-decoration: none;
}

.card a:hover {
  box-shadow: 3px 3px 8px hsl(0, 0%, 70%);
}

.card-content {
  padding: 1.4em;
}

.card-content h2 {
  margin-top: 0;
  margin-bottom: .5em;
  font-weight: normal;
}

.card-content p {
  font-size: 95%;
}

img {
  width: 100%;
  height: auto;
}

/*--------------------------------------------------------------
Flexbox card styles
--------------------------------------------------------------*/
@media screen and (min-width: 40em) {  
  .cards {
    margin-top: -1em;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
  }

  .card {
    margin-bottom: 1em;
    display: flex;
    flex: 0 1 calc(50% - 0.5em);
    /* width: calc(50% - 1em); */
  }
} /* mq 40em*/

@media screen and (min-width: 60em) {
  .cards {
    margin-top: inherit;
  }
  
  .card {
    margin-bottom: 2em;
    display: flex;
    flex: 0 1 calc(33% - 0.5em);
    /* width: calc(33% - 1em); */
  }
} /* mq 60em*/
.example {
border-radius:3px;
-moz-border-radius:3px;
-webkit-border-radius:3px;
}
/* main menu styles */
#nav {
display:inline-block;
width:100%;
margin:0px auto;
padding:0;
background:#335599 url(../images/bg.png) repeat-x 0 -110px;
border-radius:10px; /*some css3*/
-moz-border-radius:10px;
-webkit-border-radius:10px;
box-shadow:0 2px 2px rgba(0,0,0, .5);
-moz-box-shadow:0 2px 2px rgba(0,0,0, .5);
-webkit-box-shadow:0 2px 2px rgba(0,0,0, .5);
}
#nav li {
margin:10px;
float:left;
position:relative;
list-style:none;
}
#nav a {
font-weight:bold;
color:#e7e5e5;
text-decoration:none;
display:block;
padding:8px 20px;
border-radius:10px; /*some css3*/
-moz-border-radius:10px;
-webkit-border-radius:10px;
text-shadow:0 2px 2px rgba(0,0,0, .7);
}
/* selected menu element */
#nav .current a, #nav li:hover > a {
background:#7788aa url(../images/bg.png) repeat-x 0 -20px;
color:#000;
border-top:1px solid #f8f8f8;
box-shadow:0 2px 2px rgba(0,0,0, .7); /*some css3*/
-moz-box-shadow:0 2px 2px rgba(0,0,0, .7);
-webkit-box-shadow:0 2px 2px rgba(0,0,0, .7);
text-shadow:0 2px 2px rgba(255,255,255, 0.7);
}
/* sublevels */
#nav ul li:hover a, #nav li:hover li a {
background:none;
border:none;
color:#000;
}
#nav ul li a:hover {
background:#335599 url(../images/bg.png) repeat-x 0 -100px;
color:#fff;
border-radius:10px; /*some css3*/
-moz-border-radius:10px;
-webkit-border-radius:10px;
text-shadow:0 2px 2px rgba(0,0,0, 0.7);
}
#nav ul li:first-child > a {
-moz-border-radius-topleft:10px; /*some css3*/
-moz-border-radius-topright:10px;
-webkit-border-top-left-radius:10px;
-webkit-border-top-right-radius:10px;
}
#nav ul li:last-child > a {
-moz-border-radius-bottomleft:10px; /*some css3*/
-moz-border-radius-bottomright:10px;
-webkit-border-bottom-left-radius:10px;
-webkit-border-bottom-right-radius:10px;
}
/* drop down */
#nav li:hover > ul {
opacity:1;
visibility:visible;
}
#nav ul {
opacity:0;
visibility:hidden;
padding:0;
width:175px;
position:absolute;
background:#aabbcc url(../images/bg.png) repeat-x 0 0;
border:1px solid #7788aa;
border-radius:10px; /*some css3*/
-moz-border-radius:10px;
-webkit-border-radius:10px;
box-shadow:0 2px 2px rgba(0,0,0, .5);
-moz-box-shadow:0 2px 2px rgba(0,0,0, .5);
-webkit-box-shadow:0 2px 2px rgba(0,0,0, .5);
-moz-transition:opacity .25s linear, visibility .1s linear .1s;
-webkit-transition:opacity .25s linear, visibility .1s linear .1s;
-o-transition:opacity .25s linear, visibility .1s linear .1s;
transition:opacity .25s linear, visibility .1s linear .1s;
}
#nav ul li {
float:none;
margin:0;
}
#nav ul a {
font-weight:normal;
text-shadow:0 2px 2px rgba(255,255,255, 0.7);
}
#nav ul ul {
left:160px;
top:0px;
}

        </style>
    </head>
    <body>
        <div class="outer-wrap">
  <header class="masthead">        
  <div class="centered">
    <div class="site-branding">
        <h1 class="site-title"><b>MEDICARE</b></h1>
    </div><!-- .site-title -->
  </div><!-- .centered -->

      <div class="example">
<ul id="nav">
<li class="current"><a href="">Home</a></li>
<li><a href="">Login</a>
<ul>
<li><a href="a_login.html">Admin</a></li>
<li><a href="u_login.html">User</a></li>
<li><a href="d_login.html">Doctor</a></li>
<li><a href="p_login.html">Pharmacy</a></li>
</ul>
</li>
<li><a href="">Register</a>
<ul>
<li><a href="u_signup.html">User</a></li>
<li><a href="d_signup.html">Doctor</a></li>
<li><a href="p_signup.html">Pharmacy</a></li>
</ul>
</li>
<li><a href="https://www.script-tutorials.com/category/javascript/">Gallery</a>
<ul>
<li><a href="">Doctors Gallery</a></li>
<li><a href="">Medicines</a></li>
</ul>
</li>

<li><a href="https://www.script-tutorials.com/about/">About</a></li>
<li><a href="">Contact Us</a></li>
</ul>
</div>
      <!-- main-menu -->
    </header><!-- .masthead -->

    <div class="content">
      <main class="main-area">
      <div class="centered">
        <section class="cards">
          <article class="card">
            <a href="#">
              <figure class="thumbnail">
                <img src="consult.jpg" alt="meow">
              </figure>
              <div class="card-content">
                <h2>HEALTHCARE CONSULTING</h2>
                <P>With more than cumulative 2 years of experience in consulting, the people in Macula Healthcare brings in their expertise both
                    in Hospital consulting and Healthcare IT related projects. With a holistic approach, we try to bring in our experiences in the
                    form of case studies and articles in the area of healthcare consulting. These blogs are exclusively for healthcare professionals
                    and healthcare entrepreneurs.</P>
              </div> <!-- .card-content -->
            </a>
          </article><!-- .card -->

          <article class="card">
            <a href="#">
              <figure class="thumbnail">
                <img src="service.jpg" alt="meow">
              </figure>
              <div class="card-content">
                <h2>MEDICARE SERVICES</h2>
                <p>CARE SERVICESThe blogs under this category, highlights the Indian healthcare system specifically on policy, economics & schemes
                    which helps promote overall healthcare services. These blogs are generic in nature which can be applicable for any healthcare 
                    business or services.</p>
              </div><!-- .card-content -->
            </a>
          </article><!-- .card -->

          <article class="card">
            <a href="#">
              <figure class="thumbnail">
                <img src="family.jpg" alt="medi">
              </figure>
              <div class="card-content">
                <h2>Family (General) Physician</h2>
                <p>The traditional practice wherein a doctor visiting a patient’s house accompanied by a family member was absolute in the early 90s.
                    But in the recent past, doctors realized the importance of family physician and now offering services in an innovative way. 
                    Understanding the volume of patients’ needing primary care services, doctors now are working on some service models to attract
                    and educate the importance of family physician. He is the only doctor who could keep a track of patients’ health and advice on
                    healthy lifestyle.</p>
              </div><!-- .card-content -->
            </a>
          </article><!-- .card -->       


        </section><!-- .cards -->
      </div><!-- .centered -->
      </main><!-- main-area -->

      <div class="sidebar">
        <div class="squish-container">
          <h3>Explore the other Services:</h3>
          <nav class="example-menu">
            <ul>
              <li><a href="" target="_blank">Personal Doctor</a></li>
              <li><a href="" target="">Pharmacy</a></li>
              <li><a href="" target="">Medical shop</a></li>
            </ul>
          </nav><!-- .example-menu -->
        </div>
      </div><!-- .sidebar -->
    </div><!-- .content -->

  <footer class="footer-area">
      <h3>About Healthcare</h3>
    <p>The team ‘Healthcare’ is formed by domain experts in the field of Healthcare Management, Healthcare Finance and Healthcare Technology.
        With strong hold in the domain, the team brings in value through experience and knowledge and thus contributing in the field of ever growing
        sector.Understanding the healthcare holistically, prompted us to visualize the services we could offer to our clients. We understand that people
        are the pillars of an organization and we THANK all those without whom we would not have been in this place. The company has an objective and
        working consistently to achieve the same.Healthcare recognizes and acknowledges our associates and thus in coordination with Project
        Architects, Project management team, Healthcare IT and Bio-medical group we  render turnkey services to the clients with fullest commitment.</p>
  </footer>
</div><!-- .outer-wrap -->
    </body>
</html>

