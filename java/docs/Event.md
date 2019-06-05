# Event

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**eventID** | **Integer** | Идентификатор события в системе | 
**occuredAt** | [**OffsetDateTime**](OffsetDateTime.md) | Дата и время возникновения события | 
**topic** | [**TopicEnum**](#TopicEnum) | Предмет оповещения | 
**eventType** | [**EventTypeEnum**](#EventTypeEnum) | Тип произошедшего с предметом оповещения события | 

<a name="TopicEnum"></a>
## Enum: TopicEnum
Name | Value
---- | -----
INVOICESTOPIC | &quot;InvoicesTopic&quot;
CUSTOMERSTOPIC | &quot;CustomersTopic&quot;

<a name="EventTypeEnum"></a>
## Enum: EventTypeEnum
Name | Value
---- | -----
INVOICECREATED | &quot;InvoiceCreated&quot;
INVOICEPAID | &quot;InvoicePaid&quot;
INVOICECANCELLED | &quot;InvoiceCancelled&quot;
INVOICEFULFILLED | &quot;InvoiceFulfilled&quot;
PAYMENTSTARTED | &quot;PaymentStarted&quot;
PAYMENTPROCESSED | &quot;PaymentProcessed&quot;
PAYMENTCAPTURED | &quot;PaymentCaptured&quot;
PAYMENTCANCELLED | &quot;PaymentCancelled&quot;
PAYMENTREFUNDED | &quot;PaymentRefunded&quot;
PAYMENTFAILED | &quot;PaymentFailed&quot;
REFUNDCREATED | &quot;RefundCreated&quot;
REFUNDPENDING | &quot;RefundPending&quot;
REFUNDSUCCEEDED | &quot;RefundSucceeded&quot;
REFUNDFAILED | &quot;RefundFailed&quot;
CUSTOMERCREATED | &quot;CustomerCreated&quot;
CUSTOMERDELETED | &quot;CustomerDeleted&quot;
CUSTOMERREADY | &quot;CustomerReady&quot;
CUSTOMERBINDINGSTARTED | &quot;CustomerBindingStarted&quot;
CUSTOMERBINDINGSUCCEEDED | &quot;CustomerBindingSucceeded&quot;
CUSTOMERBINDINGFAILED | &quot;CustomerBindingFailed&quot;
