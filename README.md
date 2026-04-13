# Expense Tracking System

A Spring Boot-based REST API application for tracking and managing personal expenses with support for categorization and reporting.

## Features

- **Create Expenses**: Add new expense records with amount, category, and description
- **View Expenses**: Retrieve all expenses or filter by category
- **Update Expenses**: Modify existing expense entries
- **Delete Expenses**: Remove expense records
- **Expense Analytics**: Get insights into spending patterns

## Tech Stack

- **Framework**: Spring Boot 2.x / 3.x
- **Language**: Java 11+
- **Database**: MySQL
- **Build Tool**: Maven
- **Containerization**: Docker
- **Orchestration**: Kubernetes
- **CI/CD**: GitHub Actions

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- MySQL 8.0+
- Docker (for containerization)
- Kubernetes (for orchestration)

## Project Structure

```
expense-tracking-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/expense/
│   │   │   ├── controller/          # REST Controllers
│   │   │   ├── model/               # Entity Classes
│   │   │   ├── service/             # Business Logic
│   │   │   └── ExpenseApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/expense/
│           └── ExpenseServiceTest.java
├── Dockerfile                        # Container configuration
├── pom.xml                          # Maven dependencies
├── k8s/
│   ├── deployment.yaml              # Kubernetes deployment
│   └── service.yaml                 # Kubernetes service
├── .github/workflows/               # CI/CD pipelines
│   └── ci-cd.yml
└── README.md
```

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd expense-tracking-system
```

### 2. Configure Database

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Base URL: `/api/expenses`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Get all expenses |
| GET | `/{id}` | Get expense by ID |
| POST | `/` | Create new expense |
| PUT | `/{id}` | Update expense |
| DELETE | `/{id}` | Delete expense |

### Example Request

```bash
curl -X POST http://localhost:8080/api/expenses \
  -H "Content-Type: application/json" \
  -d '{
    "amount": 50.00,
    "category": "Food",
    "description": "Lunch",
    "date": "2024-01-15"
  }'
```

## Docker Deployment

### Build Docker Image

```bash
docker build -t expense-tracking-system:latest .
```

### Run Container

```bash
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-host:3306/expense_db \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=password \
  expense-tracking-system:latest
```

## Kubernetes Deployment

### Apply Configuration

```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

### Verify Deployment

```bash
kubectl get deployments
kubectl get services
kubectl get pods
```

## Running Tests

```bash
mvn test
```

## CI/CD Pipeline

The project uses GitHub Actions for automated testing and deployment. The pipeline is defined in `.github/workflows/ci-cd.yml` and includes:

- Code checkout
- Build and test
- Docker image build and push
- Kubernetes deployment

## Contributing

1. Create a feature branch: `git checkout -b feature/new-feature`
2. Commit changes: `git commit -am 'Add new feature'`
3. Push to branch: `git push origin feature/new-feature`
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues, questions, or suggestions, please open an issue in the repository.

---

**Last Updated**: April 2024
