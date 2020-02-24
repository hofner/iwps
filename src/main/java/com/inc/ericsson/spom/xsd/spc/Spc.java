//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.20 at 06:52:34 PM CDT 
//


package com.inc.ericsson.spom.xsd.spc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iwp" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="competenceSubDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lcmStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="normalHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="serviceArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="wpID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="leadTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="release" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="orderingOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="deliveryOrg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="wpOnePage" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *                   &lt;element name="workInstruction" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *                   &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="wpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="activities">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="activity" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="serviceArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="jobRoleStage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="competenceSubDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="jobRole" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="normalHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="leadTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="intensity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                                       &lt;element name="lagTime" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                                       &lt;element name="timeDependency" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *                                       &lt;element name="timeDependentActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "iwp"
})
@XmlRootElement(name = "spc")
public class Spc {

    protected List<Spc.Iwp> iwp;

    /**
     * Gets the value of the iwp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iwp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIwp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Spc.Iwp }
     * 
     * 
     */
    public List<Spc.Iwp> getIwp() {
        if (iwp == null) {
            iwp = new ArrayList<Spc.Iwp>();
        }
        return this.iwp;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="competenceSubDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lcmStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="normalHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="serviceArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="wpID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="leadTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="release" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="orderingOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="deliveryOrg" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="wpOnePage" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="workInstruction" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="wpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="activities">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="activity" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="serviceArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="jobRoleStage" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="competenceSubDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="jobRole" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="normalHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="leadTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="intensity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                             &lt;element name="lagTime" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                             &lt;element name="timeDependency" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
     *                             &lt;element name="timeDependentActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "catalogCode",
        "catalogName",
        "competenceSubDomain",
        "lcmStatus",
        "normalHours",
        "serviceArea",
        "wpID",
        "leadTime",
        "release",
        "orderingOrigin",
        "deliveryOrg",
        "wpOnePage",
        "description",
        "workInstruction",
        "category",
        "wpName",
        "activities"
    })
    public static class Iwp {

        @XmlElement(required = true)
        protected String catalogCode;
        @XmlElement(required = true)
        protected String catalogName;
        @XmlElement(required = true)
        protected String competenceSubDomain;
        @XmlElement(required = true)
        protected String lcmStatus;
        protected int normalHours;
        @XmlElement(required = true)
        protected String serviceArea;
        @XmlElement(required = true)
        protected String wpID;
        protected int leadTime;
        @XmlElement(required = true)
        protected String release;
        @XmlElement(required = true)
        protected String orderingOrigin;
        @XmlElement(required = true)
        protected String deliveryOrg;
        @XmlSchemaType(name = "anyURI")
        protected String wpOnePage;
        @XmlSchemaType(name = "anyURI")
        protected String description;
        @XmlSchemaType(name = "anyURI")
        protected String workInstruction;
        @XmlElement(required = true)
        protected String category;
        @XmlElement(required = true)
        protected String wpName;
        @XmlElement(required = true)
        protected Spc.Iwp.Activities activities;

        /**
         * Gets the value of the catalogCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCatalogCode() {
            return catalogCode;
        }

        /**
         * Sets the value of the catalogCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCatalogCode(String value) {
            this.catalogCode = value;
        }

        /**
         * Gets the value of the catalogName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCatalogName() {
            return catalogName;
        }

        /**
         * Sets the value of the catalogName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCatalogName(String value) {
            this.catalogName = value;
        }

        /**
         * Gets the value of the competenceSubDomain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompetenceSubDomain() {
            return competenceSubDomain;
        }

        /**
         * Sets the value of the competenceSubDomain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompetenceSubDomain(String value) {
            this.competenceSubDomain = value;
        }

        /**
         * Gets the value of the lcmStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLcmStatus() {
            return lcmStatus;
        }

        /**
         * Sets the value of the lcmStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLcmStatus(String value) {
            this.lcmStatus = value;
        }

        /**
         * Gets the value of the normalHours property.
         * 
         */
        public int getNormalHours() {
            return normalHours;
        }

        /**
         * Sets the value of the normalHours property.
         * 
         */
        public void setNormalHours(int value) {
            this.normalHours = value;
        }

        /**
         * Gets the value of the serviceArea property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceArea() {
            return serviceArea;
        }

        /**
         * Sets the value of the serviceArea property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceArea(String value) {
            this.serviceArea = value;
        }

        /**
         * Gets the value of the wpID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWpID() {
            return wpID;
        }

        /**
         * Sets the value of the wpID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWpID(String value) {
            this.wpID = value;
        }

        /**
         * Gets the value of the leadTime property.
         * 
         */
        public int getLeadTime() {
            return leadTime;
        }

        /**
         * Sets the value of the leadTime property.
         * 
         */
        public void setLeadTime(int value) {
            this.leadTime = value;
        }

        /**
         * Gets the value of the release property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRelease() {
            return release;
        }

        /**
         * Sets the value of the release property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRelease(String value) {
            this.release = value;
        }

        /**
         * Gets the value of the orderingOrigin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderingOrigin() {
            return orderingOrigin;
        }

        /**
         * Sets the value of the orderingOrigin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderingOrigin(String value) {
            this.orderingOrigin = value;
        }

        /**
         * Gets the value of the deliveryOrg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDeliveryOrg() {
            return deliveryOrg;
        }

        /**
         * Sets the value of the deliveryOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDeliveryOrg(String value) {
            this.deliveryOrg = value;
        }

        /**
         * Gets the value of the wpOnePage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWpOnePage() {
            return wpOnePage;
        }

        /**
         * Sets the value of the wpOnePage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWpOnePage(String value) {
            this.wpOnePage = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the workInstruction property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkInstruction() {
            return workInstruction;
        }

        /**
         * Sets the value of the workInstruction property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkInstruction(String value) {
            this.workInstruction = value;
        }

        /**
         * Gets the value of the category property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCategory() {
            return category;
        }

        /**
         * Sets the value of the category property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCategory(String value) {
            this.category = value;
        }

        /**
         * Gets the value of the wpName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWpName() {
            return wpName;
        }

        /**
         * Sets the value of the wpName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWpName(String value) {
            this.wpName = value;
        }

        /**
         * Gets the value of the activities property.
         * 
         * @return
         *     possible object is
         *     {@link Spc.Iwp.Activities }
         *     
         */
        public Spc.Iwp.Activities getActivities() {
            return activities;
        }

        /**
         * Sets the value of the activities property.
         * 
         * @param value
         *     allowed object is
         *     {@link Spc.Iwp.Activities }
         *     
         */
        public void setActivities(Spc.Iwp.Activities value) {
            this.activities = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="activity" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="serviceArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="jobRoleStage" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="competenceSubDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="jobRole" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="normalHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="leadTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="intensity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *                   &lt;element name="lagTime" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *                   &lt;element name="timeDependency" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
         *                   &lt;element name="timeDependentActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "activity"
        })
        public static class Activities {

            protected List<Spc.Iwp.Activities.Activity> activity;

            /**
             * Gets the value of the activity property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the activity property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getActivity().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Spc.Iwp.Activities.Activity }
             * 
             * 
             */
            public List<Spc.Iwp.Activities.Activity> getActivity() {
                if (activity == null) {
                    activity = new ArrayList<Spc.Iwp.Activities.Activity>();
                }
                return this.activity;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="serviceArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="jobRoleStage" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="competenceSubDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="jobRole" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="normalHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="leadTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="intensity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="lagTime" type="{http://www.w3.org/2001/XMLSchema}byte"/>
             *         &lt;element name="timeDependency" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
             *         &lt;element name="timeDependentActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "catalogCode",
                "catalogName",
                "serviceArea",
                "jobRoleStage",
                "competenceSubDomain",
                "jobRole",
                "normalHours",
                "activityName",
                "leadTime",
                "intensity",
                "lagTime",
                "timeDependency",
                "timeDependentActivity"
            })
            public static class Activity {

                @XmlElement(required = true)
                protected String catalogCode;
                @XmlElement(required = true)
                protected String catalogName;
                @XmlElement(required = true)
                protected String serviceArea;
                @XmlElement(required = true)
                protected String jobRoleStage;
                @XmlElement(required = true)
                protected String competenceSubDomain;
                @XmlElement(required = true)
                protected String jobRole;
                protected int normalHours;
                @XmlElement(required = true)
                protected String activityName;
                protected int leadTime;
                protected byte intensity;
                protected byte lagTime;
                protected Byte timeDependency;
                protected String timeDependentActivity;

                /**
                 * Gets the value of the catalogCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCatalogCode() {
                    return catalogCode;
                }

                /**
                 * Sets the value of the catalogCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCatalogCode(String value) {
                    this.catalogCode = value;
                }

                /**
                 * Gets the value of the catalogName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCatalogName() {
                    return catalogName;
                }

                /**
                 * Sets the value of the catalogName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCatalogName(String value) {
                    this.catalogName = value;
                }

                /**
                 * Gets the value of the serviceArea property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getServiceArea() {
                    return serviceArea;
                }

                /**
                 * Sets the value of the serviceArea property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setServiceArea(String value) {
                    this.serviceArea = value;
                }

                /**
                 * Gets the value of the jobRoleStage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getJobRoleStage() {
                    return jobRoleStage;
                }

                /**
                 * Sets the value of the jobRoleStage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setJobRoleStage(String value) {
                    this.jobRoleStage = value;
                }

                /**
                 * Gets the value of the competenceSubDomain property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCompetenceSubDomain() {
                    return competenceSubDomain;
                }

                /**
                 * Sets the value of the competenceSubDomain property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCompetenceSubDomain(String value) {
                    this.competenceSubDomain = value;
                }

                /**
                 * Gets the value of the jobRole property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getJobRole() {
                    return jobRole;
                }

                /**
                 * Sets the value of the jobRole property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setJobRole(String value) {
                    this.jobRole = value;
                }

                /**
                 * Gets the value of the normalHours property.
                 * 
                 */
                public int getNormalHours() {
                    return normalHours;
                }

                /**
                 * Sets the value of the normalHours property.
                 * 
                 */
                public void setNormalHours(int value) {
                    this.normalHours = value;
                }

                /**
                 * Gets the value of the activityName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getActivityName() {
                    return activityName;
                }

                /**
                 * Sets the value of the activityName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setActivityName(String value) {
                    this.activityName = value;
                }

                /**
                 * Gets the value of the leadTime property.
                 * 
                 */
                public int getLeadTime() {
                    return leadTime;
                }

                /**
                 * Sets the value of the leadTime property.
                 * 
                 */
                public void setLeadTime(int value) {
                    this.leadTime = value;
                }

                /**
                 * Gets the value of the intensity property.
                 * 
                 */
                public byte getIntensity() {
                    return intensity;
                }

                /**
                 * Sets the value of the intensity property.
                 * 
                 */
                public void setIntensity(byte value) {
                    this.intensity = value;
                }

                /**
                 * Gets the value of the lagTime property.
                 * 
                 */
                public byte getLagTime() {
                    return lagTime;
                }

                /**
                 * Sets the value of the lagTime property.
                 * 
                 */
                public void setLagTime(byte value) {
                    this.lagTime = value;
                }

                /**
                 * Gets the value of the timeDependency property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getTimeDependency() {
                    return timeDependency;
                }

                /**
                 * Sets the value of the timeDependency property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setTimeDependency(Byte value) {
                    this.timeDependency = value;
                }

                /**
                 * Gets the value of the timeDependentActivity property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTimeDependentActivity() {
                    return timeDependentActivity;
                }

                /**
                 * Sets the value of the timeDependentActivity property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTimeDependentActivity(String value) {
                    this.timeDependentActivity = value;
                }

            }

        }

    }

}
