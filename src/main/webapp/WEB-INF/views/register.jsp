<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Rejestracja</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
  </head>
  <body>
    <header>
      <nav class="container container--70">
        <ul class="nav--actions">
          <li><a href="/login">Zaloguj</a></li>
          <li class="highlighted"><a href="/register">Załóż konto</a></li>
        </ul>

        <ul>
          <li><a href="/" class="btn btn--without-border active">Start</a></li>
          <li><a href="index.jsp#steps" class="btn btn--without-border">O co chodzi?</a></li>
          <li><a href="index.jsp#about-us" class="btn btn--without-border">O nas</a></li>
          <li><a href="/" class="btn btn--without-border">Fundacje i organizacje</a></li>
          <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
      </nav>
    </header>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form method="post" action="/register" modelAttribute="user">
        <div class="form-group">
          <form:input path="username" type="email" name="username" placeholder="Email" />
          <form:errors path="username" />
        </div>
        <div class="form-group">
          <form:input path="password" type="password" name="password" placeholder="Hasło" />
          <form:errors path="password"/>
        </div>
        <div class="form-group">
          <form:input path="confirmPassword" type="password" name="confirmPassword" placeholder="Powtórz hasło" />
          <form:errors path="confirmPassword"/>
        </div>

        <div class="form-group form-group--buttons">
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>

    <footer>
      <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form>
          <div class="form-group form-group--50">
            <input type="text" name="name" placeholder="Imię" />
          </div>
          <div class="form-group form-group--50">
            <input type="text" name="surname" placeholder="Nazwisko" />
          </div>

          <div class="form-group">
            <textarea
              name="message"
              placeholder="Wiadomość"
              rows="1"
            ></textarea>
          </div>

          <button class="btn" type="submit">Wyślij</button>
        </form>
      </div>
      <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
          <a href="#" class="btn btn--small"
            ><img src="images/icon-facebook.svg"
          /></a>
          <a href="#" class="btn btn--small"
            ><img src="images/icon-instagram.svg"
          /></a>
        </div>
      </div>
    </footer>
  </body>
</html>
