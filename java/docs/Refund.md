# Refund

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Идентификатор рефанда | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Дата и время создания | 
**status** | [**StatusEnum**](#StatusEnum) | Статус рефанда | 
**error** | **Object** | Описание ошибки, возникшей в процессе проведения рефанда, в случае если рефанд завершился неуспешно  |  [optional]
**amount** | **Long** | Возвращаемая сумма, в минорных денежных единицах, например в копейках в случае указания российских рублей в качестве валюты.  | 
**currency** | **String** | Валюта, символьный код согласно [RFC 4217](http://www.iso.org/iso/home/standards/currency_codes.htm).  | 
**reason** | **String** | Причина возврата |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
SUCCEEDED | &quot;succeeded&quot;
FAILED | &quot;failed&quot;
