/**
 * RESTful FlightService<br>
 * <br>
 * Test with your browsers integrated RESTClient functionality. Firefox has a RESTClient add-on:
 * <br><br>
 * - options (OPTIONS http://localhost:8080/FlightService-war/rest/FlightService)<br>
 * - flights (GET http://localhost:8080/FlightService-war/rest/FlightService/flights/0/100)<br>
 * - flight (GET http://localhost:8080/FlightService-war/rest/FlightService/flight/EK 85/20190109)<br>
 * - exists (GET http://localhost:8080/FlightService-war/rest/FlightService/exists/SN 467/20190109)<br>
 * - pax arrivals (GET http://localhost:8080/FlightService-war/rest/FlightService/pax_arrivals/DUS/2011-10-02
 * 18:48:00/40)<br>
 * - pax dapartures (GET http://localhost:8080/FlightService-war/rest/FlightService/pax_departures/DUS/2011-10-02
 * 18:48:00/50)<br>
 * - arrivals (GET http://localhost:8080/FlightService-war/rest/FlightService/arrivals/DXB/2011-10-02 18:48:00/80)<br>
 * - departures (GET http://localhost:8080/FlightService-war/rest/FlightService/departures/FRA/2011-10-02
 * 18:48:00/50)<br>
 * - count (GET http://localhost:8080/FlightService-war/rest/FlightService/count)<br>
 * <br>
 * The test data in the database support the following:<br><br>
 * - arrival airports are KGL, EBB, DXB and DWC.<br>
 * - departure airports are BRU, KGL, DUS and FRA.<br>
 * <br>
 * The general configuration is done in <strong>web.xml</strong>:
 * <pre>{@code
 * <init-param>
 *     <param-name>jersey.config.server.provider.packages</param-name>
 *     <param-value>service</param-value>
 * </init-param>}</pre> points to the package where the service class resides (here <strong>service</strong>). The
 * following extends the URL to call (here <strong>rest</strong>):
 * <pre>{@code
 * <servlet-mapping>
 *      <servlet-name>Jersey Web Application</servlet-name>
 *      <url-pattern>/rest/*</url-pattern>
 * </servlet-mapping>}</pre> See the service calls above for examples.
 * <br>
 */
package service;
