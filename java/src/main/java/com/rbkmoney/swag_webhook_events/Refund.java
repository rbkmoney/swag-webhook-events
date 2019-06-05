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
 * Данные рефанда в рамках платежа
 */
@Schema(description = "Данные рефанда в рамках платежа")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-06-05T14:43:15.170+03:00[Europe/Moscow]")public class Refund {

  @SerializedName("id")
  private String id = null;

  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;
  /**
   * Статус рефанда
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    SUCCEEDED("succeeded"),
    FAILED("failed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("error")
  private Object error = null;

  @SerializedName("amount")
  private Long amount = null;

  @SerializedName("currency")
  private String currency = null;

  @SerializedName("reason")
  private String reason = null;
  public Refund id(String id) {
    this.id = id;
    return this;
  }

  

  /**
  * Идентификатор рефанда
  * @return id
  **/
  @Schema(required = true, description = "Идентификатор рефанда")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Refund createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  

  /**
  * Дата и время создания
  * @return createdAt
  **/
  @Schema(required = true, description = "Дата и время создания")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }
  public Refund status(StatusEnum status) {
    this.status = status;
    return this;
  }

  

  /**
  * Статус рефанда
  * @return status
  **/
  @Schema(required = true, description = "Статус рефанда")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }
  public Refund error(Object error) {
    this.error = error;
    return this;
  }

  

  /**
  * Описание ошибки, возникшей в процессе проведения рефанда, в случае если рефанд завершился неуспешно 
  * @return error
  **/
  @Schema(description = "Описание ошибки, возникшей в процессе проведения рефанда, в случае если рефанд завершился неуспешно ")
  public Object getError() {
    return error;
  }
  public void setError(Object error) {
    this.error = error;
  }
  public Refund amount(Long amount) {
    this.amount = amount;
    return this;
  }

  

  /**
  * Возвращаемая сумма, в минорных денежных единицах, например в копейках в случае указания российских рублей в качестве валюты. 
  * minimum: 1
  * @return amount
  **/
  @Schema(required = true, description = "Возвращаемая сумма, в минорных денежных единицах, например в копейках в случае указания российских рублей в качестве валюты. ")
  public Long getAmount() {
    return amount;
  }
  public void setAmount(Long amount) {
    this.amount = amount;
  }
  public Refund currency(String currency) {
    this.currency = currency;
    return this;
  }

  

  /**
  * Валюта, символьный код согласно [RFC 4217](http://www.iso.org/iso/home/standards/currency_codes.htm). 
  * @return currency
  **/
  @Schema(required = true, description = "Валюта, символьный код согласно [RFC 4217](http://www.iso.org/iso/home/standards/currency_codes.htm). ")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }
  public Refund reason(String reason) {
    this.reason = reason;
    return this;
  }

  

  /**
  * Причина возврата
  * @return reason
  **/
  @Schema(description = "Причина возврата")
  public String getReason() {
    return reason;
  }
  public void setReason(String reason) {
    this.reason = reason;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Refund refund = (Refund) o;
    return Objects.equals(this.id, refund.id) &&
        Objects.equals(this.createdAt, refund.createdAt) &&
        Objects.equals(this.status, refund.status) &&
        Objects.equals(this.error, refund.error) &&
        Objects.equals(this.amount, refund.amount) &&
        Objects.equals(this.currency, refund.currency) &&
        Objects.equals(this.reason, refund.reason);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, createdAt, status, error, amount, currency, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Refund {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
