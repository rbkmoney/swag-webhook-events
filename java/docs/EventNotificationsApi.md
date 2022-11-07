# EventNotificationsApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**notifyWebhookEvent**](EventNotificationsApi.md#notifyWebhookEvent) | **POST** /webhook-url | Оповестить о событии

<a name="notifyWebhookEvent"></a>
# **notifyWebhookEvent**
> notifyWebhookEvent(body, contentSignature)

Оповестить о событии

### Example
```java
// Import classes:
//import com.rbkmoney.ApiException;
//import com.rbkmoney.swag_webhook_events.EventNotificationsApi;


EventNotificationsApi apiInstance = new EventNotificationsApi();
Event body = new Event(); // Event | Данные произошедшего в платформе события
String contentSignature = "contentSignature_example"; // String | Подпись сообщения, сформированная согласно указанным выше правилам 
try {
    apiInstance.notifyWebhookEvent(body, contentSignature);
} catch (ApiException e) {
    System.err.println("Exception when calling EventNotificationsApi#notifyWebhookEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Event**](Event.md)| Данные произошедшего в платформе события |
 **contentSignature** | [**String**](.md)| Подпись сообщения, сформированная согласно указанным выше правилам  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: Not defined

