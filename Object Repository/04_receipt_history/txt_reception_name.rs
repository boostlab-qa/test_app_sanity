<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료내역 > 목록 > 가족 이름</description>
   <name>txt_reception_name</name>
   <tag></tag>
   <elementGuidId>f52e6571-54ed-4e48-a90e-aab7db718d52</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/iv_reception_user_name</value>
      <webElementGuid>02d65822-8ef2-4d25-8180-5bc6e5c2f7cc</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>459cc4da-1c9e-443e-ba99-a42e159be4dc</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/iv_reception_user_name' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
