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
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Данные события
 */
@Schema(description = "Данные события")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-06-05T14:43:15.170+03:00[Europe/Moscow]")
public class Event {

  @SerializedName("eventID")
  private Integer eventID = null;

  @SerializedName("occuredAt")
  private OffsetDateTime occuredAt = null;
  /**
   * Предмет оповещения
   */
  @JsonAdapter(TopicEnum.Adapter.class)
  public enum TopicEnum {
    INVOICESTOPIC("InvoicesTopic"),
    CUSTOMERSTOPIC("CustomersTopic");

    private String value;

    TopicEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static TopicEnum fromValue(String text) {
      for (TopicEnum b : TopicEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<TopicEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TopicEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TopicEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TopicEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("topic")
  private TopicEnum topic = null;
  /**
   * Тип произошедшего с предметом оповещения события
   */
  @JsonAdapter(EventTypeEnum.Adapter.class)
  public enum EventTypeEnum {
    INVOICECREATED("InvoiceCreated"),
    INVOICEPAID("InvoicePaid"),
    INVOICECANCELLED("InvoiceCancelled"),
    INVOICEFULFILLED("InvoiceFulfilled"),
    PAYMENTSTARTED("PaymentStarted"),
    PAYMENTPROCESSED("PaymentProcessed"),
    PAYMENTCAPTURED("PaymentCaptured"),
    PAYMENTCANCELLED("PaymentCancelled"),
    PAYMENTREFUNDED("PaymentRefunded"),
    PAYMENTFAILED("PaymentFailed"),
    REFUNDCREATED("RefundCreated"),
    REFUNDPENDING("RefundPending"),
    REFUNDSUCCEEDED("RefundSucceeded"),
    REFUNDFAILED("RefundFailed"),
    CUSTOMERCREATED("CustomerCreated"),
    CUSTOMERDELETED("CustomerDeleted"),
    CUSTOMERREADY("CustomerReady"),
    CUSTOMERBINDINGSTARTED("CustomerBindingStarted"),
    CUSTOMERBINDINGSUCCEEDED("CustomerBindingSucceeded"),
    CUSTOMERBINDINGFAILED("CustomerBindingFailed");

    private String value;

    EventTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static EventTypeEnum fromValue(String text) {
      for (EventTypeEnum b : EventTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<EventTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EventTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EventTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return EventTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("eventType")
  private EventTypeEnum eventType = null;
  public Event eventID(Integer eventID) {
    this.eventID = eventID;
    return this;
  }

  

  /**
  * Идентификатор события в системе
  * @return eventID
  **/
  @Schema(required = true, description = "Идентификатор события в системе")
  public Integer getEventID() {
    return eventID;
  }
  public void setEventID(Integer eventID) {
    this.eventID = eventID;
  }
  public Event occuredAt(OffsetDateTime occuredAt) {
    this.occuredAt = occuredAt;
    return this;
  }

  

  /**
  * Дата и время возникновения события
  * @return occuredAt
  **/
  @Schema(required = true, description = "Дата и время возникновения события")
  public OffsetDateTime getOccuredAt() {
    return occuredAt;
  }
  public void setOccuredAt(OffsetDateTime occuredAt) {
    this.occuredAt = occuredAt;
  }
  public Event topic(TopicEnum topic) {
    this.topic = topic;
    return this;
  }

  

  /**
  * Предмет оповещения
  * @return topic
  **/
  @Schema(required = true, description = "Предмет оповещения")
  public TopicEnum getTopic() {
    return topic;
  }
  public void setTopic(TopicEnum topic) {
    this.topic = topic;
  }
  public Event eventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    return this;
  }

  

  /**
  * Тип произошедшего с предметом оповещения события
  * @return eventType
  **/
  @Schema(required = true, description = "Тип произошедшего с предметом оповещения события")
  public EventTypeEnum getEventType() {
    return eventType;
  }
  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.eventID, event.eventID) &&
        Objects.equals(this.occuredAt, event.occuredAt) &&
        Objects.equals(this.topic, event.topic) &&
        Objects.equals(this.eventType, event.eventType);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(eventID, occuredAt, topic, eventType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    eventID: ").append(toIndentedString(eventID)).append("\n");
    sb.append("    occuredAt: ").append(toIndentedString(occuredAt)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
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
