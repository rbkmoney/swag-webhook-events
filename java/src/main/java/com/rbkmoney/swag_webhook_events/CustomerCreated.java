/*
 * RBKmoney Webhooks Events API
 *  ## Webhooks Events API  Данная спецификация определяет протокол доставки оповещений о возникновении новых событий в рамках вашей организации, которые платформа доставляет в виде HTTP-запросов на URL-адреса созданных вами webhook'ов. Обработчики для подобного рода запросов необходимо реализовать на стороне вашего серверного кода согласно данной спецификации.  Webhook — это подписка на определенный тип события либо их группу, касающихся различных объектов в рамках вашей организации. Для управления webhook'ами используются методы RBKmoney API, описанные в спецификации [RBKmoney Webhooks Management API](https://rbkmoney.github.io/api#Webhooks). Когда наступает одно из событий в рамках определенного инвойса (например, изменение статуса инвойса или платежа по этому инвойсу), платформа выбирает webhook, подходящий под этот тип события, и отправляет HTTP-запрос, содержащий сообщение в формате JSON на указанный в этом webhook'е URL. Если вы создали несколько webhook'ов, подходящих под этот тип события, то событие доставляется одновременно на все заданные в них URL в неопределённом порядке.  ## Стратегия доставки  Платформа гарантирует порядок доставки событий в рамках определенного инвойса, никакое событие не может быть пропущено и доставлено не в порядке возникновения в платформе. Платформа поддерживает очередь сообщений для каждого инвойса для того, чтобы соблюсти эти гарантии.  Запрос на доставку считается успешным только при получении ответа со статусом `200`. Платформа будет ожидать успешного ответа на отправленный запрос в течение 10 секунд. В случае ответа любым другим статусом или по истечении указанного времени, отведённого на обработку оповещения, платформа будет пытаться повторно доставить оповещения до получения успешного ответа, либо до принятия решения о невозможности доставить информацию. Попытки доставки будут производиться со следующими временными интервалами между запросами:    - 30 секунд,   - 5 минут,   - 15 минут,   - 1 час.   - каждый час в течение суток (24 часа)  Если последняя попытка доставить оповещение оканчивается неудачей, все события, которые накопились в очереди этого инвойса, отбрасываются.  ## Авторизация полученных сообщений  Платформа подтверждает подлинность оповещений, подписывая сообщения приватным ключом, уникальным для каждого webhook'а, парный публичный ключ к которому содержится в данных этого webhook'а. Подпись передается в HTTP-заголовке `Content-Signature`. В заголовке в виде различных атрибутов содержится информация об использованном при формировании подписи алгоритме и значение подписи в формате [URL-safe base-64](https://tools.ietf.org/html/rfc4648).  ``` Content-Signature: alg=RS256; digest=zFuf7bRH4RHwyktaqHQwmX5rn3LfSb4dKo... ```  На данный момент возможно использование единственного алоритма формирования подписи.  ### [RS256](https://tools.ietf.org/html/rfc7518#section-3.3)  Подпись формируется согласно алгоритму [RSASSA-PKCS1-v1_5](https://tools.ietf.org/html/rfc3447#section-8.2), на вход которому подаётся результат вычисления хэша сообщения по алгоритму [SHA-256](https://tools.ietf.org/html/rfc6234).  Набор атрибутов заголовка и список возможных алгоритмов формирования подписи в дальнейшем могут быть расширены. 
 *
 * OpenAPI spec version: 1.0
 * Contact: tech-support@rbkmoney.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.rbkmoney.swag_webhook_events;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.rbkmoney.swag_webhook_events.Customer;
import com.rbkmoney.swag_webhook_events.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Событие о создании нового плательщика
 */
@Schema(description = "Событие о создании нового плательщика")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-06-05T14:43:15.170+03:00[Europe/Moscow]")public class CustomerCreated extends Event {

  @SerializedName("customer")
  private Customer customer = null;
  public CustomerCreated customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  

  /**
  * Get customer
  * @return customer
  **/
  @Schema(required = true, description = "")
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerCreated customerCreated = (CustomerCreated) o;
    return Objects.equals(this.customer, customerCreated.customer) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(customer, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerCreated {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
