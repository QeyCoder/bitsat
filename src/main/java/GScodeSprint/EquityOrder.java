package GScodeSprint;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class EquityOrder {


    private static String orderId;
    private static String timeStamp;
    private static String symbol;
    private static ORDERTYPE ordertype;
    private static SIDE side;
    private static String price;
    private static String value;
    private static String quantity;

    private static String solution(String ip) throws InvalidAction {

        String[] query = ip.split(",");

        String action = query[0];
        switch (ACTION.valueOf(action)) {

            //AMEND ORDER
            case A:
                orderId = query[1];
                timeStamp = query[2];
                symbol = query[3];
                ordertype = ORDERTYPE.valueOf(query[4]);
                side = SIDE.valueOf(query[5]);
                price = query[6];
                quantity = query[7];

                return EquityStorage.updateOrder(orderId, timeStamp, symbol, ordertype, side, price, quantity);
            //CANCEL ORDER
            case X:
                orderId = query[1];
                timeStamp = query[2];

                return EquityStorage.cancelOrder(orderId, timeStamp);
            //MATCH ORDER
            case M:
                timeStamp = query[1];
                try {
                    symbol = query[3];
                } catch (Exception e) {
                    //eat here
                }
                EquityStorage.matchOrder(timeStamp, symbol);

                break;
            //NEW ORDER
            case N:
                orderId = query[1];
                timeStamp = query[2];
                symbol = query[3];
                ordertype = ORDERTYPE.valueOf(query[4]);
                side = SIDE.valueOf(query[5]);
                price = query[6];
                quantity = query[7];


                return EquityStorage.createOrder(orderId, timeStamp, symbol, ordertype, side, price, quantity);


            //QUERY ORDER
            case Q:
//                String s = query[1];
                break;
            default:
                throw new InvalidAction("Invalid Action");

        }
        return null;
    }


    /*
     * Complete the function below.
     */
    private static String[] processQueries(String[] queries) throws InvalidAction {
        String[] output = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String ip = queries[i];
            output[i] = solution(ip);
        }
        return output;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main2(String[] args) throws IOException, InvalidAction {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int queriesSize = Integer.parseInt(scan.nextLine().trim());

        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int responseItr = 0; responseItr < response.length; responseItr++) {
            bw.write(response[responseItr]);

            if (responseItr != response.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }

    public static void main(String[] args) throws InvalidAction {
        int queriesSize = Integer.parseInt(scan.nextLine().trim());
        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int i = 0; i < response.length; i++) {
            System.out.println(response[i]);
        }
    }

    enum ACTION {
        A("A"),

        N("N"),

        X("X"),

        M("M"),

        Q("Q");

        private final String action;

        ACTION(String action) {
            this.action = action;
        }

    }

    enum SIDE {
        B("B"),

        S("S");

        private final String side;

        SIDE(String side) {
            this.side = side;
        }

    }

    enum ORDERTYPE {
        M("M"), L("L"), I("I");

        private final String action;

        ORDERTYPE(String action) {
            this.action = action;
        }

    }

    enum ORDERRESPONSE {
        Accept("Accept"),
        Reject("Reject - 303 - Invalid order details"),
        ORDER_AMEND_ACCEPT("AmendAccept"),
        ORDER_AMEND_REJECT("AmendReject - 101 - Invalid amendment details"),
        ORDER_AMEND_REJECT_ORDER_NOT_EXIST("AmendReject - 404 - Order does not exist"),
        CANCEL_REJECT("CancelReject - 404 - Order does not exist"),
        CANCEL_ACCEPT("CancelAccept");
        private final String response;

        ORDERRESPONSE(String response) {
            this.response = response;
        }


    }

    private static class InvalidAction extends Exception {
        public InvalidAction(String msg) {
            super(msg);
        }
    }

    private static class Order {
        String orderId;
        String timeStamp;
        String symbol;
        ORDERTYPE orderType;
        SIDE side;
        String price;
        String quantity;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public ORDERTYPE getOrderType() {
            return orderType;
        }

        public void setOrderType(ORDERTYPE orderType) {
            this.orderType = orderType;
        }

        public SIDE getSide() {
            return side;
        }

        public void setSide(SIDE side) {
            this.side = side;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }
    }

    private static class EquityStorage {


        static Map<String, Order> orders = new HashMap<>();
        static Map<String, List<String>> symbolBuyOrders = new HashMap<>();
        static Map<String, List<String>> symbolSellOrders = new HashMap<>();
        private static OrderComaprator orderComparator = new OrderComaprator();

        private static String createOrder(String orderId, String timeStamp, String symbol, ORDERTYPE ordertype, SIDE side, String price, String quantity) {
            try {
                Integer.parseInt(quantity);
            } catch (Exception e) {
                return orderId + " - " + ORDERRESPONSE.Reject.response;
            }
            Order order = new Order();
            order.setOrderId(orderId);
            order.setTimeStamp(timeStamp);
            order.setSymbol(symbol);
            order.setOrderType(ordertype);
            order.setSide(side);
            order.setPrice(price);
            order.setQuantity(quantity);
            orders.put(orderId, order);
            if (side == SIDE.B) {
                List<String> orderList = symbolBuyOrders.get(symbol);
                if (orderList == null) {
                    orderList = new ArrayList<>();

                }
                orderList.add(orderId);
                symbolBuyOrders.put(symbol, orderList);
            } else {
                List<String> orderList = symbolSellOrders.get(symbol);
                if (orderList == null) {
                    orderList = new ArrayList<>();

                }
                orderList.add(orderId);
                symbolSellOrders.put(symbol, orderList);
            }
            return orderId + " - " + ORDERRESPONSE.Accept.response;

        }

        private static String updateOrder(String orderId, String timeStamp, String symbol, ORDERTYPE ordertype, SIDE side, String price, String quantity) {

            try {
                Integer.parseInt(quantity);
            } catch (Exception e) {
                return orderId + " - " + ORDERRESPONSE.ORDER_AMEND_REJECT.response;
            }
            Order order = orders.get(orderId);

            if (order == null) {
                return orderId + " - " + ORDERRESPONSE.ORDER_AMEND_REJECT_ORDER_NOT_EXIST.response;
            } else if (order.getOrderType() != ordertype || side != order.getSide() || order.getSymbol() != symbol || timeStamp != order.timeStamp) {
                return orderId + " - " + ORDERRESPONSE.ORDER_AMEND_REJECT.response;
            } else {
                //update order and return response;
                order.setQuantity(quantity);
                order.setPrice(price);
                orders.put(orderId, order);
                return orderId + " - " + ORDERRESPONSE.ORDER_AMEND_ACCEPT.response;
            }
        }

        public static String cancelOrder(String orderId, String timeStamp) {
            Order order = orders.get(orderId);
            if (order == null) {
                return orderId + " - " + ORDERRESPONSE.CANCEL_REJECT.response;
            }
            return orderId + " - " + ORDERRESPONSE.CANCEL_ACCEPT.response;
        }

        public static void matchOrder(String timeStamp, String symbol) {


            List<String> buyOrdersIds = getBuyOrders(symbol);
            List<String> sellOrdersIds = getBuyOrders(symbol);

            List<Order> buyOrders = getOrdersByIds(buyOrdersIds);
            List<Order> sellOrders = getOrdersByIds(sellOrdersIds);
            buyOrders.sort(orderComparator);
            sellOrders.sort(orderComparator);
        }

        private static List<Order> getOrdersByIds(List<String> orderIds) {
            List<Order> orderList = new ArrayList<>();
            for (String orderId : orderIds) {
                orderList.add(orders.get(orderId));
            }
            return orderList;
        }

        private static List<String> getSellOrders(String symbol) {
            if (symbol != null) {
                return symbolSellOrders.get(symbol);
            }
            Collection<List<String>> values = symbolSellOrders.values();
            List<String> sellOrders = new ArrayList<>();
            for (List<String> value : values) {
                sellOrders.addAll(value);
            }
            return sellOrders;
        }

        private static List<String> getBuyOrders(String symbol) {
            if (symbol != null) {
                return symbolBuyOrders.get(symbol);
            }
            Collection<List<String>> values = symbolBuyOrders.values();
            List<String> buyOrders = new ArrayList<>();
            for (List<String> value : values) {
                buyOrders.addAll(value);
            }
            return buyOrders;
        }


        static class OrderComaprator implements Comparator<Order> {

            @Override
            public int compare(Order o1, Order o2) {
                return 0;
            }
        }
    }
}
